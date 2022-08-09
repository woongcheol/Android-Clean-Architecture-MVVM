package com.example.firsttask.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firsttask.databinding.ItemBookBinding
import com.example.firsttask.repository.model.remote.response.BookDataVolumeInfo
import com.example.firsttask.repository.model.remote.response.volumeInfo

class BookListAdapter : RecyclerView.Adapter<BookListAdapter.Holder>() {
    private var bookList = ArrayList<volumeInfo>()

    // 항목에 사용할 뷰 생성 및 뷰 홀더 반환
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemBookBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )

        return Holder(binding)
    }

    // 항목 뷰에 데이터 연결
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val bookData = bookList.get(position)
        holder.bindBookItem(bookData)
    }

    // 아이템 개수 확인
    override fun getItemCount(): Int {
        return bookList.size
    }

    fun setList(data: ArrayList<volumeInfo>) {
        bookList = data
    }

    inner class Holder(val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindBookItem(item: volumeInfo) {
            binding.bookTitle.text = item.volumeInfo!!.title
            binding.bookDes.text = item.volumeInfo!!.description
            binding.bookAu.text = item.volumeInfo!!.authors.toString()

            // 썸네일
//            if (item.volumeInfo!!.imageLinks.thumbnail != null) {
//                Glide.with(itemView.context).load("${item.volumeInfo!!.imageLinks.thumbnail}").into(binding.imageView)
//            }

        }
    }
}