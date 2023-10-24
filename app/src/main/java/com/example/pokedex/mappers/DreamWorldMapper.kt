package com.example.pokedex.mappers

import com.example.pokedex.dto.DreamWorldDTO
import com.example.pokedex.models.DreamWorld

fun DreamWorldDTO.toDreamWorldModel(): DreamWorld {
    return DreamWorld(
        frontDefault = front_default
    )
}