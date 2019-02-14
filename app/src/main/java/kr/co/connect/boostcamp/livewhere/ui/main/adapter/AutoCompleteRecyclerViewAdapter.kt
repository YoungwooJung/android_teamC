package kr.co.connect.boostcamp.livewhere.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import kr.co.connect.boostcamp.livewhere.databinding.ItemAutoCompleteRecyclerViewBinding
import kr.co.connect.boostcamp.livewhere.ui.main.SearchViewModel

class AutoCompleteRecyclerViewAdapter(
    private val lifecycleOwner: LifecycleOwner,
    private val searchViewModel: SearchViewModel
) : RecyclerView.Adapter<AutoCompleteRecyclerViewAdapter.AutoCompleteViewHolder>() {
    private var list = listOf<String>()

    fun setData(list: List<String>) {
        this.list = list
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AutoCompleteViewHolder {
        val binding = ItemAutoCompleteRecyclerViewBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return AutoCompleteViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: AutoCompleteViewHolder, position: Int) {
        holder.bind(lifecycleOwner, list[position], searchViewModel)
    }

    inner class AutoCompleteViewHolder(
        private val itemBinding: ItemAutoCompleteRecyclerViewBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(lifecycleOwner: LifecycleOwner, text: String, searchViewModel: SearchViewModel) {
            itemBinding.setLifecycleOwner(lifecycleOwner)
            itemBinding.searchViewModel = searchViewModel
            itemBinding.autoComplete = text
        }
    }
}