package com.example.pokedex.repository

import com.example.pokedex.models.Pokemon


interface PokemonPageRepository {
    suspend fun getPokemon(name: String): Result<Pokemon>
}