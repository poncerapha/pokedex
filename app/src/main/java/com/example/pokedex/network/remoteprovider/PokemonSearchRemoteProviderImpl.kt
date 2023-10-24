package com.example.pokedex.network.remoteprovider

import com.example.pokedex.dto.PokemonSearchCardDTO
import com.example.pokedex.network.Response
import com.example.pokedex.network.restclient.PokemonSearchRestClient
import com.example.pokedex.utils.safeCall

class PokemonSearchRemoteProviderImpl(
    private val pokemonSearchRestClient: PokemonSearchRestClient
): PokemonSearchRemoteProvider {
    override suspend fun getPokemonList(
        limit: Int,
        offset: Int
    ): Response<PokemonSearchCardDTO> = safeCall {
        pokemonSearchRestClient.getPokemonList(
            limit = limit,
            offset = offset
        )
    }
}