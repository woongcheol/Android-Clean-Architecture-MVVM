package com.example.firsttask.repository.model.remote.request

import com.google.gson.annotations.SerializedName

data class BookDataThumbnail (
    @SerializedName("thumbnail") var thumbnail : String?
)