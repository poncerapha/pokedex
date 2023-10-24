package com.example.pokedex.mappers

import com.example.pokedex.dto.PokemonSearchDTO
import com.example.pokedex.models.PokemonSearch

fun PokemonSearchDTO.toPokemonSearchModel(): PokemonSearch {
    return PokemonSearch(
        count = count,
        next = next,
        previous = previous,
        results = results.map { it.toPokemonSearchModel() }
    )
}