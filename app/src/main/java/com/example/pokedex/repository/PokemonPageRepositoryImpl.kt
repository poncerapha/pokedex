package com.example.pokedex.repository

import com.example.pokedex.dto.PokemonSearchCardDTO
import com.example.pokedex.mappers.toPokemonSearchModel
import com.example.pokedex.models.Pokemon
import com.example.pokedex.network.remoteprovider.PokemonPageRemoteProvider
import com.example.pokedex.network.remoteprovider.PokemonSearchRemoteProvider
import com.example.pokedex.utils.toResult

class PokemonPageRepositoryImpl(
    private val pokemonPageRemoteProvider: PokemonPageRemoteProvider
): PokemonPageRepository {
    override suspend fun getPokemon(name: String): Result<Pokemon> {
        return pokemonPageRemoteProvider.getPokemon(
            name = name
        ).toResult().map { it.toPokemonSearchModel() }
    }
}