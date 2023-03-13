package com.longnmp.pokemon.base.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.longnmp.pokemon.databinding.LayoutItemHomeBinding

abstract class BaseAdapter<T : Any, H : ViewDataBinding> :
    RecyclerView.Adapter<BaseViewHolder<T, H>>(), DefaultLifecycleObserver {

    private val differ = AsyncListDiffer(
        getAdapterCallBack(),
        getAsyncDifferConfigBuilder()
    )

    fun addSubmit(list: List<T>) {
        differ.submitList(list.toMutableList())
    }

    private fun getDiffCallBack(): DiffUtil.ItemCallback<T> {
        return object : DiffUtil.ItemCallback<T>() {
            override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
                return areItemsTheSameItem(oldItem, newItem)
            }

            override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
                return areContentsTheSameItem(oldItem, newItem)
            }
        }
    }

    private fun getAsyncDifferConfigBuilder() = AsyncDifferConfig.Builder(getDiffCallBack()).build()

    private fun getAdapterCallBack() = RecyclerAdapterCallBack(this)

    /**
     * return layout by resource id
     */
    abstract fun layout(): Int

    /**
     * return view holder by resource id
     */
    abstract fun viewHolder(view: H): BaseViewHolder<T, H>

    /**
     * Called to check whether two objects represent the same item.
     */
    abstract fun areItemsTheSameItem(oldItem: T, newItem: T): Boolean

    /**
     * Called to check whether two items have the same data.
     */
    abstract fun areContentsTheSameItem(oldItem: T, newItem: T): Boolean

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T, H> {
        val binding = DataBindingUtil.inflate<H>(
            LayoutInflater.from(parent.context),
            layout(), parent, false,
        )
        return viewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T, H>, position: Int) {
        try {
            holder.bindData(data = differ.currentList[position] as T)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        differ.currentList.clear()
    }
}
