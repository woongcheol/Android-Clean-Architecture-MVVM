package com.example.firsttask.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firsttask.R
import com.example.firsttask.databinding.ItemBookBinding
import com.example.firsttask.repository.model.local.SelectedInfo
import com.example.firsttask.repository.model.remote.response.BookContent
import com.example.firsttask.repository.source.local.BookLocalDataSourceImpl
import com.example.firsttask.viewmodel.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SelectecBookListAdapter(val model: ViewModel):RecyclerView.Adapter<SelectecBookListAdapter.Holder>() {
    var bookList = ArrayList<SelectedInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemBookBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )

        return Holder(binding, model)    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val bookData = bookList.get(position)
        holder.bindBookItem(bookData)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    fun setList(data: List<SelectedInfo>) {
        bookList.clear()
        bookList.addAll(data)
    }

    inner class Holder(val binding: ItemBookBinding, val model: ViewModel) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindBookItem(item: SelectedInfo) {
            // 초기 값
            binding.bookTitle.text = item.title
            binding.bookDes.text = item.description ?: "내용 없음"
            binding.bookAu.text = item.authors
            binding.selectedBook.setImageResource(R.drawable.book_selected_on)

            // 썸네일 변경
            if (item.thumbnail != null) {
                Glide.with(itemView.context).load("${item.thumbnail}")
                    .fitCenter().into(binding.imageView)
            } else {
                binding.imageView.setImageResource(R.drawable.book_image_default)
            }

            // 찜 기능 - 삭제
            binding.selectedBook.setOnClickListener {
                binding.selectedBook.setImageResource(R.drawable.book_selected_off)
                model.deleteBookByTitle(item.title!!)
            }
        }
    }
}