package com.example.pokedex.network.remoteprovider

import com.example.pokedex.dto.PokemonDTO
import retrofit2.Response

interface PokemonPageRemoteProvider {
    suspend fun getPokemon(name: String): Response<PokemonDTO>
}