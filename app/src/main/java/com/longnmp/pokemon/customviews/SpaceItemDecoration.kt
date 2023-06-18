package com.longnmp.pokemon.customviews

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

/**
 * Class to add spacing between columns of recycler view
 * Require:
 * - RecyclerView have layout manager is GridLayoutManager
 * @param sizeDpResource width size of item layout
 * @param spanCount number of columns
 */
class SpaceItemDecoration(
    private val sizeDpResource: Float,
    private val spanCount: Int
) : ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val numberOffset = spanCount + 1
        val mItemSize = sizeDpResource.toInt()
        val position = parent.getChildLayoutPosition(view)
        val column: Int = position % spanCount
        val parentWidth = parent.width
        val spacing: Int = (parentWidth - mItemSize * spanCount) / (spanCount + 1)
        outRect.left = (spacing - column * spacing / spanCount) / numberOffset
        outRect.right = ((column + 1) * spacing / spanCount) / numberOffset

        if (position < spanCount) {
            outRect.top = spacing / numberOffset
        }
        outRect.bottom = spacing / numberOffset
    }
}