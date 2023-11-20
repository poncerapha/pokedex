package com.example.pokedex.network.restclient

import com.example.pokedex.dto.PokemonSearchDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonSearchRestClient {
    @GET("/api/v2/pokemon")
    suspend fun getPokemonList(
        @Query("offset") offset: Int
    ): PokemonSearchDTO
}