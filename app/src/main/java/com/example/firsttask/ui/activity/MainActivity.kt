package com.example.firsttask.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.firsttask.R
import com.example.firsttask.base.BaseActivity
import com.example.firsttask.databinding.ActivityMainBinding
import com.example.firsttask.ui.fragment.BookListFragment
import com.example.firsttask.ui.fragment.SelectedBookListFragment
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewPager 추가
        createViewPager()

    }

    fun createViewPager() {
        val bookListFragment = BookListFragment()
        val SelectedBookListFragment = SelectedBookListFragment()

        val fragments = arrayListOf<Fragment>(bookListFragment, SelectedBookListFragment)
        val tabAdapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return fragments.size
            }

            override fun createFragment(position: Int): Fragment {
                return fragments[position]
            }
        }

        binding.fragmentPager.adapter = tabAdapter
        TabLayoutMediator(binding.tabLayout, binding.fragmentPager) { tab, position ->
            when(position) {
                0 -> tab.setText("책 보기")
                else -> tab.setText("찜")
            }
        }.attach()
    }
}