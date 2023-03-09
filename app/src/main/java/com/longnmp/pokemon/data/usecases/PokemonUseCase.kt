package com.longnmp.pokemon.data.usecases

import com.longnmp.pokemon.base.network.NetworkResult
import com.longnmp.pokemon.data.models.domain.pokemon.Pokemon
import com.longnmp.pokemon.data.repositories.PokemonRepository
import com.longnmp.pokemon.di.qualifiers.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
) {

    suspend fun getPokemon() = pokemonRepository.getPokemon().map {

    }.flowOn(dispatcher)

}