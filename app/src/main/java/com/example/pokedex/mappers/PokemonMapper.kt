package com.example.pokedex.mappers

import com.example.pokedex.dto.PokemonDTO
import com.example.pokedex.models.Pokemon
import com.example.pokedex.models.PokemonSearchCard

fun PokemonDTO.toPokemonSearchModel(): Pokemon {
    return Pokemon(
        name = name
    )
}