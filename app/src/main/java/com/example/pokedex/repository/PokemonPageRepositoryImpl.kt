package com.example.pokedex.repository

import com.example.pokedex.mappers.toPokemonModel
import com.example.pokedex.models.PokemonUiState
import com.example.pokedex.network.remoteprovider.PokemonPageRemoteProvider
import com.example.pokedex.network.utils.Result

class PokemonPageRepositoryImpl(
    private val pokemonPageRemoteProvider: PokemonPageRemoteProvider
): PokemonPageRepository {
    override suspend fun getPokemon(name: String): Result<PokemonUiState> {
        return pokemonPageRemoteProvider.getPokemon(
            name = name
        ).toResult {
            it.toPokemonModel()
        }
    }
}