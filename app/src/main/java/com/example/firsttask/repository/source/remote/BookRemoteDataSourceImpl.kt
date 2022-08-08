package com.example.firsttask.repository.source.remote

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.firsttask.repository.model.remote.response.BookData
import com.example.firsttask.api.RetrofitConnection
import com.example.firsttask.repository.model.remote.response.volumeInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookRemoteDataSourceImpl() : BookRemoteDataSource {

    val _bookContent = MutableLiveData<List<volumeInfo>>()

    override fun getBookData(title:String, keyword: String) {

        Log.d("testt", "start")

        RetrofitConnection.getInstanceBack()
        val bookApi = RetrofitConnection.service.getBookData(title, keyword)

        bookApi.enqueue(object : Callback<BookData> {
                override fun onResponse(
                    call: Call<BookData>,
                    response: Response<BookData>
                ) {
                    if (response.isSuccessful) {
                        Log.d("testt", "${response.body()}")
                        _bookContent.value = response.body()!!.items!!
                    } else {
                        Log.v("로그", "응답 없음")
                    }
                }

                override fun onFailure(call: Call<BookData>, t: Throwable) {
                    Log.v("로그", "통신 실패")
                }
            })
    }
}