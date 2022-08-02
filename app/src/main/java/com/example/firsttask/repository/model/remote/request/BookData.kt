package com.example.firsttask.repository.model.remote.request

import com.google.gson.annotations.SerializedName

data class BookData(
    @SerializedName("kind") var kind: String?,
    @SerializedName("totalItems") var totalItems: Int?,
    @SerializedName("items") var items: List<BookDataItems>?
)