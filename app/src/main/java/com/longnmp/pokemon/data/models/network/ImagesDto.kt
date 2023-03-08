package com.longnmp.pokemon.data.models.network

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
)