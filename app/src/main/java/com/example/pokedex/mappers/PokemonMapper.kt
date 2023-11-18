package com.example.pokedex.mappers

import com.example.pokedex.dto.PokemonDTO
import com.example.pokedex.models.PokemonUiState

fun PokemonDTO.toPokemonModel(): PokemonUiState {
    return PokemonUiState(
        name = name,
        sprites = sprites.toSpriteModel(),
        moves = moves.map { it.toMovesModel() },
        height = height,
        weight = weight
    )
}