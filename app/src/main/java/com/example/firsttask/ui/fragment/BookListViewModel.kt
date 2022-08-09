package com.example.firsttask.ui.fragment

import androidx.lifecycle.LiveData
import com.example.firsttask.base.BaseViewModel
import com.example.firsttask.repository.model.remote.response.BookContent
import com.example.firsttask.repository.source.remote.BookRemoteDataSourceImpl

class BookListViewModel: BaseViewModel() {
    private val bookRemoteDataSourceImpl = BookRemoteDataSourceImpl()

    private val bookContent: LiveData<ArrayList<BookContent>>
        get() = bookRemoteDataSourceImpl._bookContent

    fun loadBookContent(title:String, keyword: String, page: Int) {
        bookRemoteDataSourceImpl.getBookData(title, keyword, page)
    }

    fun getAll() : LiveData<ArrayList<BookContent>> {
        return bookContent
    }
}