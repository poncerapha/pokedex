package com.example.pokedex.network.remoteprovider

import com.example.pokedex.dto.PokemonDTO
import com.example.pokedex.network.utils.Response

interface PokemonPageRemoteProvider {
    suspend fun getPokemon(name: String): Response<PokemonDTO>
}