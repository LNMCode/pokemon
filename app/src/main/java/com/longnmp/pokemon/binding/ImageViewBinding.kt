package com.longnmp.pokemon.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

object ImageViewBinding {

    @JvmStatic
    @BindingAdapter("loadUrl")
    fun bindLoadUrlImageView(view: ImageView, url: String?) {
        url?.let {
            view.load(url) {
                crossfade(true)
            }
        }
    }
}