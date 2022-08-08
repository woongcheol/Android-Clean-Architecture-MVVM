package com.example.firsttask.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import com.example.firsttask.R

import com.example.firsttask.base.BaseActivity
import com.example.firsttask.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}