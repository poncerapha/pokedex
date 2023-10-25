package com.example.pokedex.network.utils

import com.example.pokedex.dto.ErrorBody
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import retrofit2.Response as RetrofitResponse

sealed class Response<T> {
    class Success<T>(private val response: RetrofitResponse<T>) : Response<T>() {
        val value get() = response.body()
    }

    class Error<T>(val response: RetrofitResponse<T>) : Response<T>() {
        val httpCode get() = response.code()
        val httpStatusMessage get() = response.message() ?: ""
        val errorBody: ErrorBody = try {
            val jsonNode: JsonNode? = ObjectMapper().readTree(response.errorBody()?.byteStream())
            ErrorBody.fromJson(jsonNode)
        } catch (e: Exception) {
            ErrorBody()
        }
    }

    class ErrorException<T>(val exception: Exception) : Response<T>()

    fun <R> toResult(mapper: (T) -> R): Result<R> {
        return when (this) {
            is Success -> Result.Success(mapper(requireNotNull(value)))
            is Error -> Result.Error(message = httpStatusMessage, statusCode = httpCode)
            is ErrorException -> Result.Error(throwable = exception)
        }
    }

    fun toResult(): Result<Unit> = toResult(mapper = {})
}