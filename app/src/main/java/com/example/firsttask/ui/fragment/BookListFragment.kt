package com.example.firsttask.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firsttask.R
import com.example.firsttask.base.BaseFragment
import com.example.firsttask.databinding.FragmentBookListBinding
import com.example.firsttask.ui.adapter.BookListAdapter

class BookListFragment : BaseFragment<FragmentBookListBinding>(R.layout.fragment_book_list) {
    private lateinit var bookAdapter: BookListAdapter
    private var page = 0
    private val model: BookListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // 어댑터 연결
        binding.bookList.layoutManager = LinearLayoutManager(context)
        bookAdapter = BookListAdapter()
        binding.bookList.adapter = bookAdapter

        // 최초 페이지 불러오기
        model.loadBookContent("android", "books", page)
        model.getAll().observe(viewLifecycleOwner, Observer { content ->
            bookAdapter.setList(content)
            bookAdapter.notifyDataSetChanged()
        })

        // 이전 페이지
        binding.prevContent.setOnClickListener {
            if (page >= 10) {
                page -= 10
                model.loadBookContent("android", "books", page)
            }
        }

        // 다음 페이지
        binding.nextContent.setOnClickListener {
            page += 10
            model.loadBookContent("android", "books", page)
        }
    }
}
