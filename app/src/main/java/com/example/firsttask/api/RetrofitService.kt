package com.example.firsttask.api

import com.example.firsttask.repository.model.remote.response.BookData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("books/v1/volumes")
    fun getBookData(
        @Query("q") title: String,
        @Query("printType") keyword: String
    ) : Call<BookData>
}