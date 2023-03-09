package com.longnmp.pokemon.data.repositories

import com.longnmp.pokemon.base.network.NetworkResult
import com.longnmp.pokemon.data.models.domain.pokemon.Pokemon
import com.longnmp.pokemon.data.network.services.PokemonService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonService: PokemonService,
) {

    suspend fun getPokemon(): Flow<NetworkResult<List<Pokemon>>> = pokemonService.getPokemon().map {
        when (it) {
            is NetworkResult.Success -> {
                val data = it.data.map { pokemon -> pokemon.toDomain() }
                return@map NetworkResult.Success(data = data)
            }
            is NetworkResult.Error -> {
                return@map it
            }
        }
    }

}