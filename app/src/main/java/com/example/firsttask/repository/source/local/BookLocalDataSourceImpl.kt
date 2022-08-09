package com.example.firsttask.repository.source.local

import com.example.firsttask.repository.model.local.SelectedInfo

class BookLocalDataSourceImpl(private val bookDao: BookDao) : BookLocalDataSource {
    override suspend fun getLocalALL(): List<SelectedInfo> {
        return bookDao.getALL()
    }

    override suspend fun insertBook(selectedBook: SelectedInfo) {
        bookDao.insertBook(selectedBook)
    }

    override suspend fun deleteBookByTitle(title: String) {
        bookDao.deleteBookByTitle(title)
    }
}