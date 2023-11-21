package com.example.pokedex.mappers

import com.example.pokedex.dto.TypesDTO
import com.example.pokedex.models.Types

fun TypesDTO.toTypesModel() = Types(
    slot = slot,
    type = type.toTypeModel()
)