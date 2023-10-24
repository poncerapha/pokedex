package com.example.pokedex.utils

import retrofit2.Response

fun <T>Response<T>.toResult(): Result<T> {
    val body = this.body()
    val errorBody = this.errorBody()

    return when {
        body != null -> {
            Result.success(body)
        }
        errorBody != null -> {
            Result.failure(Exception(errorBody.string()))
        }
        else -> {
            Result.failure(Exception("Unknown error: ${this.raw().message()}"))
        }
    }
}