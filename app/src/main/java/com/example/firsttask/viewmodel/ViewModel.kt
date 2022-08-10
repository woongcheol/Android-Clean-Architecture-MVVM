package com.example.firsttask.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.firsttask.base.BaseViewModel
import com.example.firsttask.repository.BookRepositoryImpl
import com.example.firsttask.repository.model.local.SelectedInfo
import com.example.firsttask.repository.model.remote.response.BookContent
import kotlinx.coroutines.launch

class ViewModel(application: Application): BaseViewModel(application) {

    // Repository
    private val bookRepositoryImpl = BookRepositoryImpl(application)

    // Local
    // 찜 기능 - 책 조회
    lateinit var selectedInfoList:LiveData<List<SelectedInfo>>

    fun getLocalALL(): LiveData<List<SelectedInfo>> {
        viewModelScope.launch {
            selectedInfoList = bookRepositoryImpl.getLocalALL()
        }
        return selectedInfoList
    }

    // 찜 기능 - 책 추가
    fun insertBook(selectedBook: SelectedInfo) = viewModelScope.launch{
        bookRepositoryImpl.insertBook(selectedBook)
    }

    // 찜 기능 - 책 삭제
    fun deleteBookByTitle(title: String) = viewModelScope.launch {
        bookRepositoryImpl.deleteBookByTitle(title)
    }


    // Remote
    // Live Data 생성
    private val bookContent: LiveData<ArrayList<BookContent>>
        get() = bookRepositoryImpl.bookRemoteDataSourceImpl._bookContent

    // book data - Google api 호출
    fun loadBookContent(title:String, keyword: String, page: Int) {
        bookRepositoryImpl.getBookData(title, keyword, page)
    }

    // book data - LiveData 수신
    fun getAll() : LiveData<ArrayList<BookContent>> {
        return bookContent
    }


}