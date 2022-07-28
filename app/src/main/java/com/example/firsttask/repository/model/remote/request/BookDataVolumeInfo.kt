package com.example.firsttask.repository.model.remote.request

import com.google.gson.annotations.SerializedName

data class BookDataVolumeInfo(

    @SerializedName("thumbnail") val thumbnail : String?,
    @SerializedName("title") val title: String?,
    @SerializedName("description") val description : String?,
    @SerializedName("authors") val authors: String?

)