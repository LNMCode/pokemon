package com.longnmp.pokemon.data.models.network

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EvolutionDto(
    val detail: String,
    val id: Int,
    val image: String,
    val name: String
)