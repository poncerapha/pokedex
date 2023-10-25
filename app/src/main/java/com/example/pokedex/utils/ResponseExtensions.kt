package com.example.pokedex.utils

import com.example.pokedex.network.utils.Response
import retrofit2.Response as Retrofit2Response

suspend fun <T> safeCall(call: suspend () -> retrofit2.Response<T>): Response<T> {
    return try {
        call().formatResponse()
    } catch (e: Exception) {
        Response.ErrorException(e)
    }
}

fun <T> Retrofit2Response<T>.formatResponse(): Response<T> {
    return if (isSuccessful) {
        Response.Success(this)
    } else {
        Response.Error(this)
    }
}