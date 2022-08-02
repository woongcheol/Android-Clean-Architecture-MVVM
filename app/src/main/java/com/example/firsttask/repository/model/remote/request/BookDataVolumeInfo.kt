package com.example.firsttask.repository.model.remote.request

import com.google.gson.annotations.SerializedName

data class BookDataVolumeInfo(
    @SerializedName("title") var title: String?,
    @SerializedName("description") var description : String?,
    @SerializedName("authors") var authors: List<String>?,
    @SerializedName("imageLinks") var imageLinks: BookDataThumbnail,
)