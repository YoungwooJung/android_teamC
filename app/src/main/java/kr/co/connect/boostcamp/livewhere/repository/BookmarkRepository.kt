package kr.co.connect.boostcamp.livewhere.repository

import io.reactivex.Observable
import kr.co.connect.boostcamp.livewhere.data.entity.BookmarkEntity

interface BookmarkRepository {
    fun getBookmark(): Observable<List<BookmarkEntity>>
    fun setBookmark(bookmarkEntity: BookmarkEntity): Boolean
    fun deleteBookmark(address: String):Observable<Boolean>
}