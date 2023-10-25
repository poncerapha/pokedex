package com.example.pokedex.repository

import com.example.pokedex.models.Pokemon
import com.example.pokedex.network.utils.Result


interface PokemonPageRepository {
    suspend fun getPokemon(name: String): Result<Pokemon>
}