package com.example.firsttask.ui.activity

import android.os.Bundle
import android.util.Log
import com.example.firsttask.R

import com.example.firsttask.base.BaseActivity
import com.example.firsttask.databinding.ActivityMainBinding
import com.example.firsttask.repository.model.remote.request.BookDataItems
import com.example.firsttask.repository.retrofit.RetrofitConnection
import com.example.firsttask.repository.retrofit.RetrofitService
import com.example.firsttask.ui.adapter.BookListAdapterDecoration
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
//    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding.vm = viewModel
        getData()
        initUI()
    }

    private fun initUI() {
        binding.bookList.addItemDecoration(BookListAdapterDecoration())

    }

    private fun getData() {
        Log.d("testt", "start")

        val retrofitAPI = RetrofitConnection.getInstanceBack().create(RetrofitService::class.java)

        retrofitAPI.getBookData("android", "books")
            .enqueue(object : Callback<BookDataItems> {
                override fun onResponse(
                    call: Call<BookDataItems>,
                    response: Response<BookDataItems>
                ) {
                    if (response.isSuccessful) {
                        Log.d("testt", "${response.body()}")

                    }
                }

                override fun onFailure(call: Call<BookDataItems>, t: Throwable) {
                    t.printStackTrace()
                }
            })
    }

}