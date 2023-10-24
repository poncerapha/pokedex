package com.example.pokedex.network.remoteprovider

import com.example.pokedex.dto.PokemonDTO
import com.example.pokedex.network.restclient.PokemonPageRestClient
import retrofit2.Response

class PokemonPageRemoteProviderImpl(
    private val pokemonPageRestClient: PokemonPageRestClient
): PokemonPageRemoteProvider {
    override suspend fun getPokemon(name: String): Response<PokemonDTO> {
        return pokemonPageRestClient.getPokemon(
            name = name
        )
    }
}