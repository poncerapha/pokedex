package com.example.pokedex.network.utils

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.spyk
import io.mockk.verify
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import com.example.pokedex.network.utils.Result.Error as ResultError

class ResultTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun createResultSuccess() {
        val dataTest = "dataTest"
        val result = Result.Success(dataTest)

        Assert.assertEquals(Result.Success::class.java, result.javaClass)
        Assert.assertEquals(dataTest, result.data)
    }

    @Test
    fun createResultError() {
        val result = ResultError(
            message = "message",
            errorCode = "errorCode"
        )

        Assert.assertEquals(ResultError::class.java, result.javaClass)
        Assert.assertEquals(result.message, result.message)
        Assert.assertEquals(result.errorCode, result.errorCode)
    }

    @Test
    fun getResult_onSuccess_returnsResultSuccess() {
        val dataTest = "dataTest"
        val fakeResult = Result.Success(dataTest)
        val action = spyk<(String) -> Unit>()
        val result = fakeResult.onSuccess(action)

        Assert.assertEquals(fakeResult, result)
        verify(exactly = 1) {
            action(dataTest)
        }
    }

    @Test
    fun getResult_onError_returnsResultError() {
        val fakeError = ResultError()
        val action = spyk<(Result.Error) -> Unit>()
        val result = fakeError.onError(action)

        Assert.assertEquals(fakeError, result)
        verify(exactly = 1) {
            action(fakeError)
        }
    }
}