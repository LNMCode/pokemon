package com.longnmp.pokemon.data.network.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber

class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        Timber.d("LoggingInterceptor", "Sending request to " + request.url)

        val response = chain.proceed(request)
        Timber.d("LoggingInterceptor", "Received response from " + response.request.url)

        return response
    }
}
