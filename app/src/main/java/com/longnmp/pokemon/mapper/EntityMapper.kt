package com.longnmp.pokemon.mapper

/**
 * T is domain
 * H is entity
 * */
interface EntityMapper<T> {
    fun toEntity(): T
}