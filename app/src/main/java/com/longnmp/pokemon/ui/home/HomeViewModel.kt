package com.longnmp.pokemon.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.longnmp.pokemon.base.BaseViewModel
import com.longnmp.pokemon.data.models.domain.pokemon.Pokemon
import com.longnmp.pokemon.data.usecases.PokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import timber.log.Timber
import java.util.Timer
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val pokemonUseCase: PokemonUseCase,
) : BaseViewModel() {

    private val _pokemonData = MutableLiveData<List<Pokemon>>()
    val pokemonData: LiveData<List<Pokemon>> = _pokemonData

    init {
        fetchPokemon()
    }

    private fun fetchPokemon() {
        requestAPI {
            pokemonUseCase.getPokemon().collect { value ->
                _pokemonData.postValue(value)
                Timber.d("##### ", pokemonData.value?.size)

            }
        }

    }
}