package com.example.pokedex.repository

import com.example.pokedex.models.PokemonSearch
import com.example.pokedex.network.Result

interface PokemonSearchRepository {
    suspend fun getPokemonList(limit: Int, offset: Int): Result<PokemonSearch>
}