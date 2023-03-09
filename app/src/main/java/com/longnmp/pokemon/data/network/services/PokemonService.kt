package com.longnmp.pokemon.data.network.services

import com.longnmp.pokemon.base.network.BaseNetworkService
import com.longnmp.pokemon.base.network.NetworkResult
import com.longnmp.pokemon.data.models.network.PokemonDto
import com.longnmp.pokemon.data.network.apis.APIService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import javax.inject.Inject

class PokemonService @Inject constructor(
    private val apiService: APIService,
) : BaseNetworkService() {

    suspend fun getPokemon(): Flow<NetworkResult<List<PokemonDto>>> = flow {
        Timber.d("request api", "getPokemon service on ${Thread.currentThread().name}")
        val result = requestAPI { apiService.getPokemon() }
        emit(result)
    }

}