package com.example.pokedex.mappers

import com.example.pokedex.dto.TypeDTO
import com.example.pokedex.models.Type

fun TypeDTO.toTypeModel() = Type(
    name = name,
    url = url
)