package com.example.pokedex.mappers

import com.example.pokedex.dto.MoveDTO
import com.example.pokedex.models.Move

fun MoveDTO.toMoveModel(): Move {
    return Move(
        name = name
    )
}