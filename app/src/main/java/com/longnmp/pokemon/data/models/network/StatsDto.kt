package com.longnmp.pokemon.data.models.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StatsDto(
    val attack: Int,
    val defense: Int,
    val hp: Int,

    @field:Json(name = "special-attack")
    val specialAttack: Int,

    @field:Json(name = "special-defense")
    val specialDefense: Int,
    val speed: Int
)