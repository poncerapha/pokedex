package com.example.pokedex.network.restclient

import com.example.pokedex.dto.PokemonDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonPageRestClient {
    @GET("pokemon/{name}")
    suspend fun getPokemon(
        @Path("name") name: String
    ): Response<PokemonDTO>
}