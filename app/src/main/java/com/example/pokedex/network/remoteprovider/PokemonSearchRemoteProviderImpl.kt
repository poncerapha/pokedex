package com.example.pokedex.network.remoteprovider

import com.example.pokedex.dto.PokemonSearchDTO
import com.example.pokedex.network.restclient.PokemonSearchRestClient
import com.example.pokedex.network.utils.Response
import com.example.pokedex.utils.safeCall

class PokemonSearchRemoteProviderImpl(
    private val pokemonSearchRestClient: PokemonSearchRestClient
): PokemonSearchRemoteProvider {
    override suspend fun getPokemonList(
        limit: Int,
        offset: Int
    ): Response<PokemonSearchDTO> = safeCall {
        pokemonSearchRestClient.getPokemonList(
            limit = limit,
            offset = offset
        )
    }
}