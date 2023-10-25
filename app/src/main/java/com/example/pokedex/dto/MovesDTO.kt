package com.example.pokedex.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class MovesDTO(
    @JsonProperty("move") val move: MoveDTO
)