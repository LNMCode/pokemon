package com.longnmp.pokemon.base

import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.hilt.android.AndroidEntryPoint

abstract class BaseActivity<T: ViewDataBinding>(
    @LayoutRes private val contentLayoutId: Int,
) : AppCompatActivity(){

    open val viewModel by viewModels<BaseViewModel>()

    private var _binding: T? = null

    protected val binding: T
        get() = checkNotNull(_binding) {
            "Activity $this binding cannot be accessed"
        }

    protected inline fun binding(block: T.() -> Unit): T {
        return binding.apply(block)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, contentLayoutId) as T
        binding.run { lifecycleOwner = this@BaseActivity }
    }

    open fun showLoading(isShow: Boolean) {

    }

    open fun showErrorDialog(messageId: String) {

    }

    open fun showNotifyDialog(messageId: String) {

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
