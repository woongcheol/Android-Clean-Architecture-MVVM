package com.example.firsttask.repository.source.remote

import com.example.firsttask.repository.model.remote.response.BookData

interface BookRemoteDataSource {

    // 책 데이터
    fun getBookData(title:String, keyword: String)
}