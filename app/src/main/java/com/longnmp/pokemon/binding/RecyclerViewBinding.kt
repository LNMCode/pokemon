package com.longnmp.pokemon.binding

import androidx.compose.ui.unit.Dp
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.longnmp.pokemon.customviews.SpaceItemDecoration
import com.longnmp.pokemon.data.models.domain.pokemon.Pokemon
import com.longnmp.pokemon.ui.home.HomeRecyclerAdapter

object RecyclerViewBinding {
    /**
     * Binding adapter for RecyclerView Pokemon in Home Screen
     * @param view default view
     * @param list list of pokemon to submit data into Adapter
     */
    @JvmStatic
    @BindingAdapter("adapterRVPokemon")
    fun bindAdapterRVPokemon(
        view: RecyclerView,
        list: List<Pokemon>?,
    ) {
        val adapter = view.adapter
        if (adapter == null) view.adapter = HomeRecyclerAdapter()
        if (!list.isNullOrEmpty()) {
            if (adapter is HomeRecyclerAdapter) {
                adapter.addSubmit(list)
            }
        }
    }

    /**
     * Add spacing between columns of RecyclerView
     * Require:
     * - RecyclerView have layout manager is GridLayoutManager
     * Requirement values of binding:
     * @param isEnable gridLayoutSpaceBetween (Boolean) It is checking enable space between columns
     * @param sizeSpacing gridLayoutSizeSpacing (Float) It is width size of item layout
     * @param spanCount gridLayoutSpanCount (Int) It is number of columns GridLayoutManager
     */
    @JvmStatic
    @BindingAdapter(
        value = ["gridLayoutSpaceBetween", "gridLayoutSizeSpacing", "gridLayoutSpanCount"],
        requireAll = true,
    )
    fun bindHaveSpaceBetween(
        view: RecyclerView,
        isEnable: Boolean = false,
        sizeSpacing: Float,
        spanCount: Int,
    ) {
        val layoutManager = view.layoutManager
        // Checking enable and layout manager is GridLayoutManager
        if (!isEnable || layoutManager !is GridLayoutManager) return
        val itemDecoration = SpaceItemDecoration(sizeSpacing, spanCount)
        view.addItemDecoration(itemDecoration)
    }

}