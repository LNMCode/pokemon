package com.longnmp.pokemon.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.Navigation
import com.longnmp.pokemon.common.EventObserver

abstract class BaseFragment<T : ViewDataBinding>(
    @LayoutRes private val contentLayoutId: Int
) : Fragment() {

    open val viewModel by viewModels<BaseViewModel>()

    private val bindingComponent = DataBindingUtil.getDefaultComponent()

    private var _binding: T? = null

    protected val binding: T
        get() = checkNotNull(_binding) {
            "Fragment $this binding cannot be accessed before onCreateView() or after onDestroyView()"
        }

    protected inline fun binding(block: T.() -> Unit): T {
        return binding.apply(block)
    }

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(
            inflater,
            contentLayoutId,
            container,
            false,
            bindingComponent
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        setUpLayout()
        setUpEvents()
    }

    /**
     * set up layout binding with view
     */
    abstract fun setUpLayout()

    abstract fun setUpEvents()

    protected fun navigationToId(navigationId: Int) {
        val view = requireView()
        Navigation.findNavController(view).navigate(navigationId)
    }

    protected fun showLoading(isShow: Boolean) {
        val activity = requireActivity()
        if (activity is BaseActivity<*>) {
            activity.showLoading(isShow)
        }
    }

    protected fun showErrorDialog(messageId: String) {
        val activity = requireActivity()
        if (activity is BaseActivity<*>) {
            activity.showErrorDialog(messageId)
        }
    }

    protected fun showNotifyDialog(messageId: String) {
        val activity = requireActivity()
        if (activity is BaseActivity<*>) {
            activity.showNotifyDialog(messageId)
        }
    }

    protected fun registerAllEvent(
        viewModel: BaseViewModel,
        viewLifecycleOwner: LifecycleOwner,
    ) {
        registerBaseNetworkException(viewModel, viewLifecycleOwner)
        registerObserverLoading(viewModel, viewLifecycleOwner)

    }

    protected fun registerBaseNetworkException(
        viewModel: BaseViewModel,
        viewLifecycleOwner: LifecycleOwner,
    ) {
        viewModel.baseNetworkException.observe(viewLifecycleOwner, EventObserver {
            showNotifyDialog(it.mainMessage)
        })
    }

    protected fun registerObserverLoading(
        viewModel: BaseViewModel,
        viewLifecycleOwner: LifecycleOwner,
    ) {
        viewModel.isLoading.observe(viewLifecycleOwner, EventObserver {
            showLoading(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}