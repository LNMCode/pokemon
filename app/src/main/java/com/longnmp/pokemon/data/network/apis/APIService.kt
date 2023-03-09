package com.longnmp.pokemon.data.network.apis

import com.longnmp.pokemon.data.models.network.PokemonDto
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET("pokemon")
    suspend fun getPokemon() : Response<List<PokemonDto>>

}