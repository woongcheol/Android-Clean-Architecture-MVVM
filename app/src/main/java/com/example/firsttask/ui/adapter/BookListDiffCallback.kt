package com.example.firsttask.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.firsttask.repository.model.remote.response.BookContent

class BookListDiffCallback(
    private val oldList: ArrayList<BookContent>,
    private val newList: ArrayList<BookContent>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].volumeInfo == newList[newItemPosition].volumeInfo

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]
}