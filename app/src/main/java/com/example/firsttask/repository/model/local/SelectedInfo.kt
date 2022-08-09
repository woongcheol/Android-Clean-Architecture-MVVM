package com.example.firsttask.repository.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "selected_Info")
data class SelectedInfo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Int,
    @SerializedName("title") var title: String?,
    @SerializedName("description") var description: String?,
    @SerializedName("authors") var authors: String?,
    @SerializedName("thumbnail") var thumbnail: String?
)