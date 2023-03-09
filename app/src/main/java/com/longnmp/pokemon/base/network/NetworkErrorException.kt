package com.longnmp.pokemon.base.network

/**
 * NetworkErrorException is handle exception about network
 * or catch exception don't must be from response from API.
 */
class NetworkErrorException(
    private val responseMessage: String? = null
) : Exception() {
}