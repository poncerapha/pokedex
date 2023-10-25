package com.example.pokedex.mappers

import com.example.pokedex.dto.MovesDTO
import com.example.pokedex.models.Moves

fun MovesDTO.toMovesModel(): Moves {
    return Moves(
        move = move.toMoveModel()
    )
}