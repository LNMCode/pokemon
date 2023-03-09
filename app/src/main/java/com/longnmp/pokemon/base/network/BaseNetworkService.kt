package com.longnmp.pokemon.base.network

import retrofit2.Response
import timber.log.Timber

abstract class BaseNetworkService : BaseService() {

    protected suspend fun <T: Any> requestAPI(call: suspend () -> Response<T>): NetworkResult<T> {
        val response : Response<T>
        try {
            response = call.invoke()
        } catch (t: Throwable) {
            Timber.e("requestAPI","BaseRemoteService ${t.message}")
            return NetworkResult.Error(parseNetworkErrorException(t))
        }

        return if (response.isSuccessful) {
            if (response.body() == null) {
                NetworkResult.Error(BaseNetworkException(responseMessage = "Response without body", responseCode = 200))
            } else {
                NetworkResult.Success(response.body()!!)
            }
        } else {
            val errorBody = response.errorBody()?.string() ?: ""
            NetworkResult.Error(parseError(response.message(), response.code(), errorBody))
        }
    }

}
