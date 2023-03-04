package com.longnmp.pokemon.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.longnmp.pokemon.common.Event
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
open class BaseViewModel : ViewModel() {

    var isLoading = MutableLiveData<Event<Boolean>>()
        protected set
}