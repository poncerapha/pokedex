package com.example.pokedex.dto


import com.google.gson.annotations.SerializedName

data class PokemonSearchDTO(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String? = null,
    @SerializedName("results") val results: List<PokemonCardDTO>
)