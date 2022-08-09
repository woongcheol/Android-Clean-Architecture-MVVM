package com.example.firsttask.repository.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.firsttask.repository.model.local.SelectedInfo

@Database(
    entities = [SelectedInfo::class],
    version = 1
)
abstract class BookDB : RoomDatabase() {
    abstract fun bookDao(): BookDao

    companion object {
        private var INSTANCE: BookDB? = null

        fun getInstance(context: Context): BookDB = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, BookDB::class.java, "Book.db")
                .build()
    }
}