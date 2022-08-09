package com.example.firsttask.repository.source.local

import com.example.firsttask.repository.model.local.SelectedInfo


interface BookLocalDataSource {

    suspend fun getLocalALL(): List<SelectedInfo>

    suspend fun insertBook(selectedBook: SelectedInfo)

    suspend fun deleteBookByTitle(title: String)

}