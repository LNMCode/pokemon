package com.longnmp.pokemon.data.models.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonDto(
    val detail: String,

    @field:Json(name = "evolution")
    val evolutionDto: List<EvolutionDto>,
    val forms: List<String>,
    val id: Int,

    @field:Json(name = "images")
    val imagesDto: ImagesDto,
    val location: String,
    val name: String,

    @field:Json(name = "stats")
    val statsDto: StatsDto,
    val types: List<String>
)