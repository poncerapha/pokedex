package com.example.pokedex.network.utils

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class UiStateTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun createUiStateSuccess() {
        val dataTest = "dataTest"
        val uiState = UIState.Success(dataTest)

        assertEquals(UIState.Success::class.java, uiState.javaClass)
        assertEquals(dataTest, uiState.data)
    }

    @Test
    fun createUiStateError() {
        val errorData = Result.Error(
            message = "message",
            errorCode = "errorCode"
        )
        val uiState = UIState.Error<Any>(errorData)

        assertEquals(UIState.Error::class.java, uiState.javaClass)
        assertEquals(errorData.message, uiState.errorData?.message)
        assertEquals(errorData.errorCode, uiState.errorData?.errorCode)
    }

    @Test
    fun createUiStateLoading() {
        val uiState = UIState.Loading<Any>()
        assertEquals(UIState.Loading::class.java, uiState.javaClass)
    }

    @Test
    fun getDataFromGenericState_returnsUiStateSuccessData() {
        val dataTest = "dataTest"
        val uiState:UIState<String> = UIState.Success(dataTest)

        assertEquals(dataTest, uiState.data)
    }

    @Test
    fun getDataFromGenericState_returnsUiStateErrorData() {
        val errorData = Result.Error(
            message = "message",
            errorCode = "errorCode"
        )
        val uiState:UIState<String> = UIState.Error(errorData)
        assertEquals(errorData, uiState.errorData)
    }
}