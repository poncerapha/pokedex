package com.example.pokedex.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class PokemonSearchCardDTO(
    @JsonProperty("name") val name: String
)