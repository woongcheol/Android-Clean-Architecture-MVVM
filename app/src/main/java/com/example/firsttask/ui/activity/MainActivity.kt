package com.example.firsttask.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firsttask.R
import com.example.firsttask.base.BaseActivity
import com.example.firsttask.databinding.ActivityMainBinding
import com.example.firsttask.ui.adapter.BookListAdapter

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private lateinit var bookAdapter: BookListAdapter
    private var page = 0
    private val model:MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 어댑터 연결
        binding.bookList.layoutManager = LinearLayoutManager(baseContext)
        bookAdapter = BookListAdapter()
        binding.bookList.adapter = bookAdapter

        // 최초 페이지 불러오기
        model.loadBookContent("android", "books", page)
        model.getAll().observe(this, Observer { content ->
            bookAdapter.setList(content)
            bookAdapter.notifyDataSetChanged()
        })

        // 이전 페이지
        binding.prevContent.setOnClickListener {
            if (page > 11) {
                page -= 11
                model.loadBookContent("android", "books", page)
            }
        }

        // 다음 페이지
        binding.nextContent.setOnClickListener {
            page += 11
            model.loadBookContent("android", "books", page)
        }


    }

}