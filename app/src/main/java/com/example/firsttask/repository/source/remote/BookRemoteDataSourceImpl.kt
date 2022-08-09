package com.example.firsttask.repository.source.remote

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.firsttask.repository.model.remote.response.BookData
import com.example.firsttask.api.RetrofitConnection
import com.example.firsttask.repository.model.remote.response.BookContent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookRemoteDataSourceImpl() : BookRemoteDataSource {

    val _bookContent = MutableLiveData<ArrayList<BookContent>>()

    override fun getBookData(title:String, keyword: String, page:Int) {

        RetrofitConnection.getInstanceBack()
        val bookApi = RetrofitConnection.service!!.getBookData(title, keyword, page)

        bookApi.enqueue(object : Callback<BookData> {
                override fun onResponse(
                    call: Call<BookData>,
                    response: Response<BookData>
                ) {
                    if (response.isSuccessful) {
                        Log.d("testt", "${response.body()!!.items!!}")
                        _bookContent.value = response.body()!!.items!!
                    } else {
                        Log.d("testt", "응답 없음")
                    }
                }

                override fun onFailure(call: Call<BookData>, t: Throwable) {
                    Log.d("testt", "통신 실패")
                }
            })
    }
}