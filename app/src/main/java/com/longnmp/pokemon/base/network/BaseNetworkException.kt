package com.longnmp.pokemon.base.network


/**
 * BaseNetworkException for exception from request API
 */
class BaseNetworkException(
    private val responseMessage: String? = null,
    private val responseCode: Int = -1
) : Exception() {
    var mainMessage = ""

    fun parseFromString(errorBody: String) {

    }
}
