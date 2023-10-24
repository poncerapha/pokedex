package com.example.pokedex.network.remoteprovider

import com.example.pokedex.dto.PokemonSearchCardDTO
import com.example.pokedex.network.restclient.PokemonSearchRestClient
import retrofit2.Response

class PokemonSearchRemoteProviderImpl(
    private val pokemonSearchRestClient: PokemonSearchRestClient
): PokemonSearchRemoteProvider {
    override suspend fun getPokemonList(
        limit: Int,
        offset: Int
    ): Response<PokemonSearchCardDTO> {
        return pokemonSearchRestClient.getPokemonList(
            limit = limit,
            offset = offset
        )
    }
}