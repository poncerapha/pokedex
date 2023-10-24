package com.example.pokedex.mappers

import com.example.pokedex.dto.PokemonSearchCardDTO
import com.example.pokedex.models.PokemonSearchCard

fun PokemonSearchCardDTO.toPokemonSearchModel(): PokemonSearchCard {
    return PokemonSearchCard(
        name = name
    )
}