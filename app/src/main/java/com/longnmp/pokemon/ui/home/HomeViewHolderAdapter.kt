package com.longnmp.pokemon.ui.home

import android.view.View
import com.longnmp.pokemon.base.adapter.BaseViewHolder
import com.longnmp.pokemon.data.models.domain.pokemon.Pokemon
import com.longnmp.pokemon.databinding.LayoutItemHomeBinding

class HomeViewHolderAdapter(
    private val binding: LayoutItemHomeBinding,
) : BaseViewHolder<Pokemon, LayoutItemHomeBinding>(binding) {
    override fun bindData(data: Pokemon) {
        binding.pokemon = data
    }

    override fun onClick(p0: View?) {
    }

}