package com.example.firsttask.api

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitConnection {
    companion object {
        private const val BASE_URL = "https://www.googleapis.com/"
        var service: RetrofitService? = null
        private var INSTANCE: Retrofit? = null

        fun getInstanceBack(): Retrofit {
            if (INSTANCE == null) {
                val okHttpClient = OkHttpClient.Builder()
                    .readTimeout(1, TimeUnit.MINUTES)
                    .build()


                INSTANCE = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            service = INSTANCE!!.create(RetrofitService::class.java)
            return INSTANCE!!
        }
    }
}