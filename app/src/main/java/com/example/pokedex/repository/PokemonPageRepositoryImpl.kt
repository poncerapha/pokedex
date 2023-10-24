package com.example.pokedex.repository

import com.example.pokedex.dto.PokemonSearchCardDTO
import com.example.pokedex.network.remoteprovider.PokemonSearchRemoteProvider
import com.example.pokedex.utils.toResult

class PokemonPageRepositoryImpl(
    private val pokemonSearchRemoteProvider: PokemonSearchRemoteProvider
): PokemonPageRepository {
}