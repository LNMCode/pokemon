package com.longnmp.pokemon.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.longnmp.pokemon.data.models.domain.pokemon.Pokemon
import com.longnmp.pokemon.ui.home.HomeRecyclerAdapter

object RecyclerViewBinding {
    @JvmStatic
    @BindingAdapter("adapterRVPokemon")
    fun bindAdapterRVPokemon(
        view: RecyclerView,
        list: List<Pokemon>,
    ) {
        val adapter = view.adapter
        if (list.isNotEmpty() && adapter != null) {
            if (adapter is HomeRecyclerAdapter) {
                adapter.addSubmit(list)
            }
        }
    }
}