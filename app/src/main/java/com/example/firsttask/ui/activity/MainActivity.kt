package com.example.firsttask.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firsttask.R
import com.example.firsttask.api.RetrofitConnection
import com.example.firsttask.api.RetrofitConnection.Companion.getInstanceBack

import com.example.firsttask.base.BaseActivity
import com.example.firsttask.databinding.ActivityMainBinding
import com.example.firsttask.ui.adapter.BookListAdapter

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private lateinit var bookAdapter: BookListAdapter
    private val model:MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.bookList.layoutManager = LinearLayoutManager(baseContext)
        bookAdapter = BookListAdapter()
        binding.bookList.adapter = bookAdapter

        model.loadBookContent("android", "books")

        model.getAll().observe(this, Observer { content ->
            bookAdapter.setList(content)
            bookAdapter.notifyDataSetChanged()
        })
    }

}