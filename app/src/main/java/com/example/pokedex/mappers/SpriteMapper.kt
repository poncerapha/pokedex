package com.example.pokedex.mappers

import com.example.pokedex.dto.SpriteDTO
import com.example.pokedex.models.Sprite

fun SpriteDTO.toSpriteModel(): Sprite {
    return Sprite(
        others = other.toOthersModel()
    )
}