package com.example.pokedex.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class SpriteDTO(
    @JsonProperty("other") val other: OthersDTO
)
