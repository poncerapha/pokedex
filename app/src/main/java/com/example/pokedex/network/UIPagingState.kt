package com.example.pokedex.network


sealed class UIPagingState<T> {
    open class Success<T>(val data: T) : UIPagingState<T>()
    open class Error<T>(val errorData: Result.Error? = null) : UIPagingState<T>()
    open class Loading<T> : UIPagingState<T>()
    open class PagingError<T>(val errorData: Result.Error? = null) : UIPagingState<T>()
    open class PagingLoading<T> : UIPagingState<T>()
}

val <T> UIPagingState<T>.data: T?
    get() = (this as? UIPagingState.Success)?.data

val <T> UIPagingState<T>.errorData: Result.Error?
    get() {
        return when (this) {
            is UIPagingState.Error -> this.errorData
            is UIPagingState.PagingError -> this.errorData
            else -> null
        }
    }