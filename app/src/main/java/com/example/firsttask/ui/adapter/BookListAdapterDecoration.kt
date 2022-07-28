package com.example.firsttask.ui.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class BookListAdapterDecoration : RecyclerView.ItemDecoration() {

    /**
     * 리사이클러뷰 아이템 간격 조정
     *
     * @param outRect 아이템 테두리
     * @param view 데코레이트할 자식 뷰
     * @param parent 해당 데코레이션 클래스를 추가한 리사이클러뷰
     * @param state 현재 리사이클러뷰 상태
     */
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val offset = 20 // 간격

        outRect.top = offset
        outRect.bottom = offset

    }
}