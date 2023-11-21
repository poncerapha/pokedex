package com.example.pokedex.network.utils

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.pokedex.dto.ErrorBody
import io.mockk.every
import io.mockk.mockk
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import retrofit2.Response as RetrofitResponse

class ResponseTest {
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private val fakeRetrofitResponse = mockk<RetrofitResponse<String>>()

    @Test
    fun createResponseSuccess() {
        val dataTest = "dataTest"
        val response = Response.Success(fakeRetrofitResponse)

        every {
            fakeRetrofitResponse.body()
        } returns dataTest

        assertEquals(response.value, fakeRetrofitResponse.body())
    }

    @Test
    fun createResponseError_withoutErrorBody() {
        val errorCode = 500
        val message = "fakeMessage"

        every {
            fakeRetrofitResponse.code()
        } returns errorCode

        every {
            fakeRetrofitResponse.message()
        } returns message

        every {
            fakeRetrofitResponse.errorBody()
        } returns null

        val response = Response.Error(fakeRetrofitResponse)
        assertEquals(errorCode, response.httpCode)
        assertEquals(message, response.httpStatusMessage)
        assertEquals(ErrorBody(), response.errorBody)
    }

    @Test
    fun createResponseError_withErrorBody() {
        val errorCode = 500
        val message = "fakeMessage"
        val errorBodyErrorCode = "fakeErrorBodyErrorCode"
        val errorBodyMessage = "fakeErrorBodyMessage"
        val errorBody = """{
                "errorCode": "$errorBodyErrorCode",
                "message": "$errorBodyMessage"
            }""".trimMargin().toResponseBody("application/json".toMediaType())
        val expectedErrorBody = ErrorBody(
            message = errorBodyMessage,
            errorCode = errorBodyErrorCode
        )

        every {
            fakeRetrofitResponse.code()
        } returns errorCode

        every {
            fakeRetrofitResponse.message()
        } returns message

        every {
            fakeRetrofitResponse.errorBody()
        } returns errorBody

        val response = Response.Error(fakeRetrofitResponse)
        assertEquals(errorCode, response.httpCode)
        assertEquals(message, response.httpStatusMessage)
        assertEquals(expectedErrorBody, response.errorBody)
    }

    @Test
    fun createResponseErrorException() {
        val exception = Exception()

        val response = Response.ErrorException<Any>(exception)
        assertEquals(exception, response.exception)
    }

    @Test
    fun toResult_whenSuccessResponse_returnsResultSuccess() {
        val dataResult = "dataResult"
        val dataResponse = "dataResponse"

        every {
            fakeRetrofitResponse.body()
        } returns dataResponse

        val successResponse: Response<String> = Response.Success(fakeRetrofitResponse)
        val successResult = successResponse.toResult { dataResult }

        assertEquals(Result.Success::class.java, successResult.javaClass)
        assertEquals(dataResult, (successResult as Result.Success).data)
    }

    @Test
    fun toResult_whenErrorResponse_returnsResultError() {
        val dataResult = "dataResult"
        val errorCode = 500
        val message = "fakeMessage"

        every {
            fakeRetrofitResponse.code()
        } returns errorCode

        every {
            fakeRetrofitResponse.message()
        } returns message

        val errorResponse: Response<String> = Response.Error(fakeRetrofitResponse)
        val errorResult = errorResponse.toResult { dataResult }

        assertEquals(Result.Error::class.java, errorResult.javaClass)
        (errorResult as Result.Error).apply {
            assertEquals(message, message)
            assertEquals(errorCode, statusCode)
        }
    }

    @Test
    fun toResult_whenErrorExceptionResponse_returnsResultError() {
        val dataResult = "dataResult"
        val exception = Exception()

        val errorResponse: Response<Any> = Response.ErrorException(exception)
        val errorResult = errorResponse.toResult { dataResult }

        assertEquals(Result.Error::class.java, errorResult.javaClass)
        assertEquals(exception, (errorResult as Result.Error).throwable)
    }
}