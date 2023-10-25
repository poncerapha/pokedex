package com.example.pokedex.mappers

import com.example.pokedex.dto.PokemonDTO
import com.example.pokedex.models.Pokemon

fun PokemonDTO.toPokemonModel(): Pokemon {
    return Pokemon(
        name = name,
        sprites = sprites.toSpriteModel(),
        moves = moves.map { it.toMovesModel() },
        height = height,
        weight = weight
    )
}