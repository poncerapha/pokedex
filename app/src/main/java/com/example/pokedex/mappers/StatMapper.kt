package com.example.pokedex.mappers

import com.example.pokedex.dto.StatDTO
import com.example.pokedex.models.Stat

fun StatDTO.toStatModel() = Stat(
    name = name,
    url = url
)