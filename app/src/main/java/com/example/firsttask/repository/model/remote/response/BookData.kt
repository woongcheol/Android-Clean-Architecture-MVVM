package com.example.firsttask.repository.model.remote.response

import com.google.gson.annotations.SerializedName

data class BookData(
    @SerializedName("items") var items: List<volumeInfo>?
)

data class volumeInfo(
    @SerializedName("volumeInfo") var volumeInfo: BookDataVolumeInfo?
)

data class BookDataVolumeInfo(
    @SerializedName("title") var title: String?,
    @SerializedName("description") var description : String?,
    @SerializedName("authors") var authors: List<String>?,
    @SerializedName("imageLinks") var imageLinks: BookDataThumbnail,
)

data class BookDataThumbnail (
    @SerializedName("thumbnail") var thumbnail : String?
)