package com.example.pokedex.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class PokemonDTO(
    @JsonProperty("name") val name: String,
    @JsonProperty("sprites") val sprites: SpriteDTO,
    @JsonProperty("height") val height: Int,
    @JsonProperty("weight") val weight: Int
)
