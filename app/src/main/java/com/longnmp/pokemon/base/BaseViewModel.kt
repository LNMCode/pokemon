package com.longnmp.pokemon.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.longnmp.pokemon.base.network.BaseNetworkException
import com.longnmp.pokemon.common.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    var parentJob: Job? = null
        protected set

    var onNavigationToPage = MutableLiveData<Event<Int>>()
        protected set

    var isLoading = MutableLiveData<Event<Boolean>>()
        protected set

    var isLoadMore = MutableLiveData<Event<Boolean>>()

    var baseNetworkException = MutableLiveData<Event<BaseNetworkException>>()
        protected set

    val handlerException = CoroutineExceptionHandler { _, e -> parseErrorCallApi(e) }

    protected fun registerJobFinish() {
        parentJob?.invokeOnCompletion { showLoading(false) }
    }

    protected fun navigationToPage(actionId: Int) {
        onNavigationToPage.postValue(Event(actionId))
    }

    protected fun showLoading(isShow: Boolean) {
        isLoading.postValue(Event(isShow))
    }

    protected fun showLoadingMore(isShow: Boolean) {
        isLoadMore.postValue(Event(isShow))
    }

    protected open fun parseErrorCallApi(e: Throwable) {
        when (e) {
            is BaseNetworkException -> {
                baseNetworkException.postValue(Event(e))
            }
            else -> {
                val exception = BaseNetworkException()
                exception.mainMessage = e.message ?: ""
                baseNetworkException.postValue(Event(exception))
            }
        }
    }

    protected fun requestAPI(block: suspend () -> Unit) {
        showLoading(true)
        parentJob = viewModelScope.launch(handlerException) { block() }
        registerJobFinish()
    }

    /**
     * Handle more exception
     */
    /*protected open fun parseErrorCallApi(e: Throwable) {
        when (e) {
            is BaseNetworkException -> {
                baseNetworkException.postValue(Event(e))
            }
            is NetworkErrorException -> {
                networkException.postValue(Event(e))
            }
            else -> {
                val unknowException = BaseNetworkException()
                unknowException.mainMessage = e.message ?: "Something went wrong"
                baseNetworkException.postValue(Event(unknowException))
            }
        }
    }*/
}