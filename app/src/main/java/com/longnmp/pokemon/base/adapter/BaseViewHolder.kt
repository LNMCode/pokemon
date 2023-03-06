package com.longnmp.pokemon.base.adapter

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T: ViewDataBinding>(
    private val binding: T
) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

    abstract fun bindData(data: Any)
}