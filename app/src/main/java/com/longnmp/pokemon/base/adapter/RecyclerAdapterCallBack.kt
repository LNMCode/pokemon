package com.longnmp.pokemon.base.adapter

import android.annotation.SuppressLint
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListUpdateCallback

@SuppressLint("NotifyDataSetChanged")
class RecyclerAdapterCallBack<T : Any, H: ViewDataBinding>(
    private val adapter: BaseAdapter<T, H>
) : ListUpdateCallback {
    override fun onInserted(position: Int, count: Int) {
        adapter.notifyItemChanged(position, count)
    }

    override fun onRemoved(position: Int, count: Int) {
        adapter.notifyDataSetChanged()
    }

    override fun onMoved(fromPosition: Int, toPosition: Int) {
        adapter.notifyDataSetChanged()
    }

    override fun onChanged(position: Int, count: Int, payload: Any?) {
        adapter.notifyItemRangeChanged(position, count, payload)
    }
}