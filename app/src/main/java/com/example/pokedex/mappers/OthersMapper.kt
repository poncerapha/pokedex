package com.example.pokedex.mappers

import com.example.pokedex.dto.OthersDTO
import com.example.pokedex.models.Others

fun OthersDTO.toOthersModel(): Others {
    return Others(
        dreamWorld = dream_world.toDreamWorldModel()
    )
}