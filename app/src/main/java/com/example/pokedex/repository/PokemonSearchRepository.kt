package com.example.pokedex.repository

import com.example.pokedex.models.PokemonSearchCard

interface PokemonSearchRepository {
    suspend fun getPokemonList(limit: Int, offset: Int): Result<PokemonSearchCard>
}