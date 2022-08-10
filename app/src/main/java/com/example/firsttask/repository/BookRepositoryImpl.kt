package com.example.firsttask.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.firsttask.repository.model.local.SelectedInfo
import com.example.firsttask.repository.source.local.BookDB
import com.example.firsttask.repository.source.local.BookDao
import com.example.firsttask.repository.source.local.BookLocalDataSourceImpl
import com.example.firsttask.repository.source.remote.BookRemoteDataSourceImpl

class BookRepositoryImpl(application: Application): BookRepository {
    private val bookLocalDataSourceImpl : BookLocalDataSourceImpl
    val bookRemoteDataSourceImpl: BookRemoteDataSourceImpl


    init {
        bookLocalDataSourceImpl = BookLocalDataSourceImpl(application)
        bookRemoteDataSourceImpl = BookRemoteDataSourceImpl()
    }

    override suspend fun getLocalALL(): LiveData<List<SelectedInfo>> {
        return bookLocalDataSourceImpl.getLocalALL()
    }

    override suspend fun insertBook(selectedBook: SelectedInfo) {
        bookLocalDataSourceImpl.insertBook(selectedBook)
    }

    override suspend fun deleteBookByTitle(title: String) {
        bookLocalDataSourceImpl.deleteBookByTitle(title)
    }

    override fun getBookData(title: String, keyword: String, page: Int) {
        bookRemoteDataSourceImpl.getBookData(title, keyword, page)
    }
}