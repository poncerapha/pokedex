package com.example.pokedex.network.remoteprovider

import com.example.pokedex.dto.PokemonDTO
import com.example.pokedex.network.AppRetrofit
import com.example.pokedex.network.utils.Response
import com.example.pokedex.network.restclient.PokemonPageRestClient
import com.example.pokedex.utils.safeCall

class PokemonPageRemoteProviderImpl(
    private val pokemonPageRestClient: PokemonPageRestClient = AppRetrofit().pokemonPageRestClient
): PokemonPageRemoteProvider {
    override suspend fun getPokemon(
        name: String
    ): Response<PokemonDTO> = safeCall {
        pokemonPageRestClient.getPokemon(
            name = name
        )
    }
}