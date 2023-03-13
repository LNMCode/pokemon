package com.longnmp.pokemon.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.longnmp.pokemon.R
import com.longnmp.pokemon.base.BaseFragment
import com.longnmp.pokemon.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override val viewModel by viewModels<HomeViewModel>()

    override fun setUpLayout() {
        binding.viewModel = viewModel
    }

    override fun setUpEvents() {
    }

}
