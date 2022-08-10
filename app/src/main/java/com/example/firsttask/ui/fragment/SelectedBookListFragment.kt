package com.example.firsttask.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firsttask.R
import com.example.firsttask.base.BaseFragment
import com.example.firsttask.databinding.FragmentBookListBinding
import com.example.firsttask.databinding.FragmentSelectedBookListBinding
import com.example.firsttask.repository.BookRepositoryImpl
import com.example.firsttask.repository.model.local.SelectedInfo
import com.example.firsttask.repository.source.local.BookDB
import com.example.firsttask.repository.source.local.BookLocalDataSourceImpl
import com.example.firsttask.ui.adapter.BookListAdapter
import com.example.firsttask.ui.adapter.SelectecBookListAdapter
import com.example.firsttask.viewmodel.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SelectedBookListFragment :
    BaseFragment<FragmentSelectedBookListBinding>(R.layout.fragment_selected_book_list) {
    private lateinit var selectedbookAdapter: SelectecBookListAdapter
    private val model: ViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // 어댑터 연결
        initRecyclerView()

        model.getLocalALL().observe(viewLifecycleOwner, Observer {
            selectedbookAdapter.setList(it)
            selectedbookAdapter.notifyDataSetChanged()
        })


    }

    private fun initRecyclerView() {
        binding.bookList.layoutManager = LinearLayoutManager(context)
        selectedbookAdapter = SelectecBookListAdapter(model)
        binding.bookList.adapter = selectedbookAdapter
    }

}

