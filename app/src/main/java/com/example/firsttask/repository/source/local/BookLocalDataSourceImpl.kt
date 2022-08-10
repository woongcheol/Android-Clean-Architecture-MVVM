package com.example.firsttask.repository.source.local

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.firsttask.repository.model.local.SelectedInfo
import com.example.firsttask.repository.model.remote.response.BookContent
import com.example.firsttask.repository.source.remote.BookRemoteDataSourceImpl

class BookLocalDataSourceImpl(application: Application) : BookLocalDataSource {
    private val bookDao : BookDao
    private val selectedInfoList: LiveData<List<SelectedInfo>>
    val bookRemoteDataSourceImpl : BookRemoteDataSourceImpl

    init {
        var bookDB = BookDB.getInstance(application)
        bookDao = bookDB.bookDao()
        selectedInfoList = bookDB.bookDao().getLocalALL()
        bookRemoteDataSourceImpl = BookRemoteDataSourceImpl()
    }

    override suspend fun getLocalALL(): LiveData<List<SelectedInfo>> {
        return bookDao.getLocalALL()
    }

    override suspend fun insertBook(selectedBook: SelectedInfo) {
        bookDao.insertBook(selectedBook)
    }

    override suspend fun deleteBookByTitle(title: String) {
        bookDao.deleteBookByTitle(title)
    }
}