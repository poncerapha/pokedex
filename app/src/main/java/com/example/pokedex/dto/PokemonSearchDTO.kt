package com.example.pokedex.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.google.gson.annotations.SerializedName

@JsonIgnoreProperties(ignoreUnknown = true)
data class PokemonSearchDTO(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String,
    @SerializedName("results") val results: List<PokemonCardDTO>
)