package com.longnmp.pokemon.ui.home

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.longnmp.pokemon.R
import com.longnmp.pokemon.base.adapter.BaseAdapter
import com.longnmp.pokemon.base.adapter.BaseViewHolder
import com.longnmp.pokemon.data.models.domain.pokemon.Pokemon
import com.longnmp.pokemon.databinding.LayoutItemHomeBinding

class HomeRecyclerAdapter : BaseAdapter<Pokemon, LayoutItemHomeBinding>() {
    override fun layout(): Int = R.layout.layout_item_home

    override fun viewHolder(view: LayoutItemHomeBinding) = HomeViewHolderAdapter(view)

    override fun areContentsTheSameItem(oldItem: Pokemon, newItem: Pokemon) = oldItem == newItem

    override fun areItemsTheSameItem(oldItem: Pokemon, newItem: Pokemon) = oldItem.id == newItem.id
}