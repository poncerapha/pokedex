package com.example.pokedex.network

import com.example.pokedex.network.utils.Response.*
import com.example.utils.MainCoroutineRule
import com.example.pokedex.utils.formatResponse
import com.example.pokedex.utils.safeCall
import com.example.utils.MockkStaticLog.mockLog
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import java.util.Date
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import retrofit2.Response

@ExperimentalCoroutinesApi
class ResponseExtensionsTest {
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private val fakeResponse = mockk<Response<Date>>()
    private val fakeData = mockk<Date>()

    @Test
    fun formatResponse_whenIsSuccessful_returnResponseSuccess() {
        every {
            fakeResponse.isSuccessful
        } returns true

        every {
            fakeResponse.body()
        } returns fakeData

        val response = fakeResponse.formatResponse()
        assertEquals(Success::class.java, response.javaClass)
        Assert.assertEquals(fakeData, (response as Success).value)
    }

    @Test
    fun formatResponse_whenIsNotSuccessful_returnResponseError() {
        val expectedHttpCode = 500
        every {
            fakeResponse.isSuccessful
        } returns false

        every {
            fakeResponse.code()
        } returns expectedHttpCode

        val response = fakeResponse.formatResponse()
        assertEquals(Error::class.java, response.javaClass)
        Assert.assertEquals(expectedHttpCode, (response as Error).httpCode)
    }

    @Test
    fun safeCall_whenIsInvoked_returnsResponse() = runTest {
        mockkStatic(Response<Date>::formatResponse)
        val expectedResponse = mockk<com.example.pokedex.network.utils.Response<Date>>()

        every {
            fakeResponse.formatResponse()
        } returns expectedResponse

        val response = safeCall {
            fakeResponse
        }

        assertEquals(expectedResponse, response)
    }

    @Test
    fun safeCall_whenIsInvokedWithException_returnsResponseException() = runTest {
        val exception = Exception("fake exception")
        mockLog()
        val response = safeCall<Any> {
            throw exception
        }

        assertEquals(ErrorException::class.java, response.javaClass)
        assertEquals(exception, (response as ErrorException).exception)
    }
}