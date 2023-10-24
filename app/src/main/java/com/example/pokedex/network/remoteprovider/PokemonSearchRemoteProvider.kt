package com.example.pokedex.network.remoteprovider

import com.example.pokedex.dto.PokemonSearchDTO
import com.example.pokedex.network.Response

interface PokemonSearchRemoteProvider {
    suspend fun getPokemonList(limit: Int, offset: Int): Response<PokemonSearchDTO>
}