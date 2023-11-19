package com.example.pokedex.repository

import com.example.pokedex.mappers.toPokemonSearchModel
import com.example.pokedex.models.PokemonSearch
import com.example.pokedex.network.remoteprovider.PokemonSearchRemoteProvider
import com.example.pokedex.network.utils.Result

class PokemonSearchRepositoryImpl(
    private val pokemonSearchRemoteProvider: PokemonSearchRemoteProvider
): PokemonSearchRepository {
    override suspend fun getPokemonList(
        limit: Int, offset: Int)
        : Result<PokemonSearch> {
        return pokemonSearchRemoteProvider.getPokemonList(
            limit = limit,
            offset = offset
        ).toResult { it.toPokemonSearchModel() }
    }
}