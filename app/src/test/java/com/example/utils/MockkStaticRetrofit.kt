package com.example.utils

import com.example.pokedex.utils.formatResponse
import io.mockk.mockkStatic
import retrofit2.Response

object MockkStaticRetrofit {
    fun mockRetrofit() {
        mockkStatic(Response<Any>::formatResponse)
    }
}