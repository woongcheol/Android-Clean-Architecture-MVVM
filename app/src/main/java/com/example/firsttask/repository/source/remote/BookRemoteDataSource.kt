package com.example.firsttask.repository.source.remote

import com.example.firsttask.repository.model.remote.response.BookData

interface BookRemoteDataSource {

    // Book Content Data 호출
    fun getBookData(title:String, keyword: String, page:Int)
}