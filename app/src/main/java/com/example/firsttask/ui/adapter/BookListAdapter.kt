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
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


class BookListAdapter(val bookLocalDataSource: BookLocalDataSourceImpl) :
    RecyclerView.Adapter<BookListAdapter.Holder>() {
    private var bookList = ArrayList<BookContent>()


    // 항목에 사용할 뷰 생성 및 뷰 홀더 반환
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemBookBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )

        return Holder(binding, bookLocalDataSource)
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

    fun setList(data: ArrayList<BookContent>) {
        bookList = data
    }

    inner class Holder(val binding: ItemBookBinding, val bookLocalDataSource: BookLocalDataSourceImpl) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindBookItem(item: BookContent) {
            // 초기 값
            binding.bookTitle.text = item.volumeInfo!!.title
            binding.bookDes.text = item.volumeInfo!!.description ?: "내용 없음"
            binding.bookAu.text = item.volumeInfo!!.authors.toString()
            binding.selectedBook.setImageResource(R.drawable.book_selected_off)

            // 썸네일 변경
            if (item.volumeInfo!!.imageLinks != null) {
                Glide.with(itemView.context).load("${item.volumeInfo!!.imageLinks.thumbnail!!}")
                    .fitCenter().into(binding.imageView)
            } else {
                binding.imageView.setImageResource(R.drawable.book_image_default)
            }

            // 찜 기능
            binding.selectedBook.setOnClickListener {
                binding.selectedBook.setImageResource(R.drawable.book_selected_on)

                // DB 입력 객체 생성
                val item = SelectedInfo(
                    0,
                    item.volumeInfo!!.title,
                    item.volumeInfo!!.description ?: "내용 없음",
                    item.volumeInfo!!.authors.toString(),
                    item.volumeInfo!!.imageLinks.thumbnail
                )

                // DB 입력 - 코루틴
                GlobalScope.launch {
                    bookLocalDataSource.insertBook(item)
                    Log.d("testt DB", "${bookLocalDataSource.getLocalALL()}")
                }
            }
        }
    }
}