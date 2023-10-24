package com.example.pokedex.repository

import com.example.pokedex.mappers.toPokemonSearchModel
import com.example.pokedex.models.PokemonSearchCard
import com.example.pokedex.network.Result
import com.example.pokedex.network.remoteprovider.PokemonSearchRemoteProvider

class PokemonSearchRepositoryImpl(
    private val pokemonSearchRemoteProvider: PokemonSearchRemoteProvider
): PokemonSearchRepository {
    override suspend fun getPokemonList(
        limit: Int, offset: Int)
        : Result<PokemonSearchCard> {
        return pokemonSearchRemoteProvider.getPokemonList(
            limit = limit,
            offset = offset
        ).toResult { it.toPokemonSearchModel() }
    }
}