package com.longnmp.pokemon.mapper

interface DomainMapper<T> {
    fun toDomain(): T
}