package com.example.pokedex.dto

import com.google.gson.annotations.SerializedName

data class PokemonSearchDTO(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String,
    @SerializedName("results") val results: List<PokemonDTO>
)