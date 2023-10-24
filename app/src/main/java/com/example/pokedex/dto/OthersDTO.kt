package com.example.pokedex.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class OthersDTO(
    @JsonProperty("dream_world") val dream_world: DreamWorldDTO
)
