package com.example.pokedex.network.utils

sealed class UIState<T> {
    open class Success<T>(val data: T) : UIState<T>()
    open class Error<T>(val errorData: Result.Error? = null) : UIState<T>()
    open class Loading<T> : UIState<T>()
}

val <T> UIState<T>.data: T?
    get() = (this as? UIState.Success)?.data

val <T> UIState<T>.errorData: Result.Error?
    get() = (this as? UIState.Error<T>)?.errorData