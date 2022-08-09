package com.example.firsttask.viewmodel

import androidx.lifecycle.LiveData
import com.example.firsttask.base.BaseViewModel
import com.example.firsttask.repository.model.local.SelectedInfo
import com.example.firsttask.repository.model.remote.response.BookContent
import com.example.firsttask.repository.source.local.BookDao
import com.example.firsttask.repository.source.local.BookLocalDataSourceImpl
import com.example.firsttask.repository.source.remote.BookRemoteDataSourceImpl

class ViewModel(): BaseViewModel() {

    // Remote
    private val bookRemoteDataSourceImpl = BookRemoteDataSourceImpl()

    private val bookContent: LiveData<ArrayList<BookContent>>
        get() = bookRemoteDataSourceImpl._bookContent

    // book data - Google api 호출
    fun loadBookContent(title:String, keyword: String, page: Int) {
        bookRemoteDataSourceImpl.getBookData(title, keyword, page)
    }

    // book data - LiveData 수신
    fun getAll() : LiveData<ArrayList<BookContent>> {
        return bookContent
    }
}