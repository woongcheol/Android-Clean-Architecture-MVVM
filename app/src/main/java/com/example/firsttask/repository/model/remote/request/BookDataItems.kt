package com.example.firsttask.repository.model.remote.request

import com.google.gson.annotations.SerializedName

data class BookDataItems(
    @SerializedName("volumeInfo") var volumeInfo: List<BookData>
)