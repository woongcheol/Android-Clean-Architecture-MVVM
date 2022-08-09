package com.example.firsttask.ui.activity

import androidx.lifecycle.LiveData
import com.example.firsttask.base.BaseViewModel
import com.example.firsttask.repository.model.remote.response.BookDataVolumeInfo
import com.example.firsttask.repository.model.remote.response.volumeInfo
import com.example.firsttask.repository.source.remote.BookRemoteDataSourceImpl

class MainViewModel: BaseViewModel() {
    private val bookRemoteDataSourceImpl = BookRemoteDataSourceImpl()

    private val bookContent: LiveData<ArrayList<volumeInfo>>
        get() = bookRemoteDataSourceImpl._bookContent

    fun loadBookContent(title:String, keyword: String) {
        bookRemoteDataSourceImpl.getBookData(title, keyword)
    }

    fun getAll() : LiveData<ArrayList<volumeInfo>> {
        return bookContent
    }
}