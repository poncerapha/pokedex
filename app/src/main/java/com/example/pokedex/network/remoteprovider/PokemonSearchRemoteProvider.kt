package com.example.pokedex.network.remoteprovider

import com.example.pokedex.dto.PokemonSearchDTO

interface PokemonSearchRemoteProvider {
    suspend fun getPokemonList(limit: Int, offset: Int): PokemonSearchDTO
}