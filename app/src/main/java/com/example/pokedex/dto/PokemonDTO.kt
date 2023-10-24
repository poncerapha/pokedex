package com.example.pokedex.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class PokemonDTO(
    @JsonProperty("name") val name: String
)
