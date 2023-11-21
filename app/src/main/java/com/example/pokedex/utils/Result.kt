package com.example.pokedex.utils

open class Result<out R> {
    class Success<out T>(val data: T) : Result<T>()
    open class Error(
        val message: String? = null,
        val errorCode: String? = null,
        val statusCode: Int = 0,
        val throwable: Throwable? = null
    ) : Result<Nothing>()
}

inline fun <T> Result<T>.onSuccess(action: (T) -> Unit): Result<T> {
    if (this is Result.Success) action(data)
    return this
}

inline fun <T> Result<T>.onError(action: (Error) -> Unit): Result<T> {
    if (this is Error) action(this)
    return this
}