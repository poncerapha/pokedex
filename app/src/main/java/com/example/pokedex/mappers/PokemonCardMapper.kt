package com.example.pokedex.mappers

import com.example.pokedex.dto.PokemonCardDTO
import com.example.pokedex.models.PokemonCard

fun PokemonCardDTO.toPokemonCardModel(): PokemonCard {
    return PokemonCard(
        name = name,
        url = url
    )
}