package com.longnmp.pokemon.domain.pokemon

data class Pokemon(
    val detail: String,
    val evolutions: List<Evolution>,
    val forms: List<String>,
    val id: Int,
    val images: Images,
    val location: String,
    val name: String,
    val stats: Stats,
    val types: List<String>
)