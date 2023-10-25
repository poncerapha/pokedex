package com.example.pokedex.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class MoveDTO(
    @JsonProperty("name") val name: String
)