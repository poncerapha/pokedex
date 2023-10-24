package com.example.pokedex.mappers

import com.example.pokedex.dto.PokemonDTO
import com.example.pokedex.models.Pokemon

fun PokemonDTO.toPokemonSearchModel(): Pokemon {
    return Pokemon(
        name = name
    )
}