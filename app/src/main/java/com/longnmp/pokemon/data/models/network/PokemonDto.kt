package com.longnmp.pokemon.data.models.network

import com.longnmp.pokemon.data.models.domain.pokemon.Pokemon
import com.longnmp.pokemon.mapper.DomainMapper
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonDto(
    val detail: String,

    @field:Json(name = "evolutions")
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
) : DomainMapper<Pokemon> {
    override fun toDomain() = Pokemon(
        detail = detail,
        evolutions = evolutionDto.map { it.toDomain() },
        forms = forms,
        id = id,
        images = imagesDto.toDomain(),
        location = location,
        name = name,
        stats = statsDto.toDomain(),
        types = types,
    )
}