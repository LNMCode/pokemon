package com.longnmp.pokemon.data.models.network

import com.longnmp.pokemon.data.models.domain.pokemon.Stats
import com.longnmp.pokemon.mapper.DomainMapper
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlin.math.acos

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
) : DomainMapper<Stats> {
    override fun toDomain() = Stats(
        attack = attack,
        defense = defense,
        hp = hp,
        specialAttack = specialAttack,
        specialDefense = specialDefense,
        speed = speed,
    )
}