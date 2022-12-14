package com.example.firsttask.repository.source.local

import androidx.lifecycle.LiveData
import com.example.firsttask.repository.model.local.SelectedInfo


interface BookLocalDataSource {

    suspend fun getLocalALL(): LiveData<List<SelectedInfo>>

    suspend fun insertBook(selectedBook: SelectedInfo)

    suspend fun deleteBookByTitle(title: String)

}