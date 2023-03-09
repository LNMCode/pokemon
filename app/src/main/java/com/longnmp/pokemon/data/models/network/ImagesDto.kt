package com.longnmp.pokemon.data.models.network

import com.longnmp.pokemon.data.models.domain.pokemon.Images
import com.longnmp.pokemon.mapper.DomainMapper
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImagesDto(
    @field:Json(name = "back")
    val back: String,

    @field:Json(name = "front")
    val front: String,

    @field:Json(name = "shiny-back")
    val shinyBack: String,

    @field:Json(name = "shiny-front")
    val shinyFront: String
) : DomainMapper<Images> {
    override fun toDomain() = Images(
        back = back,
        front = front,
        shinyBack = shinyBack,
        shinyFront = shinyFront,
    )
}