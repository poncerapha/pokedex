package com.example.pokedex.utils

import android.util.Log
import com.example.pokedex.network.Response

suspend fun <T> safeCall(call: suspend () -> retrofit2.Response<T>): Response<T> {
    return try {
        call().formatResponse()
    } catch (e: Exception) {
        Log.e("safe call", e.message, e)
        Response.ErrorException(e)
    }
}

fun <T> retrofit2.Response<T>.formatResponse(): Response<T> {
    return if (isSuccessful) {
        Response.Success(this)
    } else {
        Response.Error(this)
    }
}