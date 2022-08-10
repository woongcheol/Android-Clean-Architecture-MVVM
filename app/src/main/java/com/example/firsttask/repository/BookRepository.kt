package com.example.firsttask.repository

import androidx.lifecycle.LiveData
import com.example.firsttask.repository.model.local.SelectedInfo

interface BookRepository {

    // Local
    // 찜 기능 - 책 조회
    suspend fun getLocalALL(): LiveData<List<SelectedInfo>>

    // 찜 기능 - 책 추가
    suspend fun insertBook(selectedBook: SelectedInfo)

    // 찜 기능 - 책 삭제
    suspend fun deleteBookByTitle(title: String)

    // Remote
    // 책 조회
    fun getBookData(title:String, keyword: String, page:Int)
}