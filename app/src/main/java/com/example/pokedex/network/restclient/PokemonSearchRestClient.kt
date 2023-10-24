package com.example.pokedex.network.restclient

import com.example.pokedex.dto.PokemonSearchDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonSearchRestClient {
    @GET("/pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<PokemonSearchDTO>
}