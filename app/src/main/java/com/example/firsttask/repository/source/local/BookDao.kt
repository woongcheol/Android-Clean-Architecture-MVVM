package com.example.firsttask.repository.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.firsttask.repository.model.local.SelectedInfo

@Dao
interface BookDao {
    @Query("SELECT * FROM selected_Info")
    suspend fun getALL(): List<SelectedInfo>

    @Insert(onConflict = REPLACE)
    suspend fun insertBook(selectedBook: SelectedInfo)

    @Query("DELETE FROM selected_Info WHERE title = :title")
    suspend fun deleteBookByTitle(title: String)
}