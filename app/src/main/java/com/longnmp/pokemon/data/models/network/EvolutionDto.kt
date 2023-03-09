package com.longnmp.pokemon.data.models.network

import com.longnmp.pokemon.data.models.domain.pokemon.Evolution
import com.longnmp.pokemon.mapper.DomainMapper
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EvolutionDto(
    val detail: String,
    val id: Int,
    val image: String,
    val name: String
): DomainMapper<Evolution> {
    override fun toDomain() = Evolution(
        detail = detail,
        id = id,
        image = image,
        name = name,
    )
}