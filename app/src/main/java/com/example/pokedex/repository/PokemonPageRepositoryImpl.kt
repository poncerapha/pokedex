package com.example.pokedex.repository

import com.example.pokedex.mappers.toPokemonSearchModel
import com.example.pokedex.models.Pokemon
import com.example.pokedex.network.Result
import com.example.pokedex.network.remoteprovider.PokemonPageRemoteProvider

class PokemonPageRepositoryImpl(
    private val pokemonPageRemoteProvider: PokemonPageRemoteProvider
): PokemonPageRepository {
    override suspend fun getPokemon(name: String): Result<Pokemon> {
        return pokemonPageRemoteProvider.getPokemon(
            name = name
        ).toResult {
            it.toPokemonSearchModel()
        }
    }
}