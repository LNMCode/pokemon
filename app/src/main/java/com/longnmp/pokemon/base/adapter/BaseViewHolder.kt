package com.longnmp.pokemon.base.adapter

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T: Any, H: ViewDataBinding>(
    private val binding: H
) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

    abstract fun bindData(data: T)
}