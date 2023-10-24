package com.example.pokedex.network.remoteprovider

import com.example.pokedex.dto.PokemonSearchCardDTO
import retrofit2.Response

interface PokemonSearchRemoteProvider {
    suspend fun getPokemonList(limit: Int, offset: Int): Response<PokemonSearchCardDTO>
}