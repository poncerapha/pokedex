package com.example.pokedex.dto

import com.google.gson.annotations.SerializedName

data class PokemonDTO(
    @SerializedName("name") val name: String,
    @SerializedName("sprites") val sprites: SpriteDTO,
    @SerializedName("moves") val moves: List<MovesDTO>,
    @SerializedName("height") val height: Int,
    @SerializedName("weight") val weight: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("types") val types: List<TypesDTO>,
    @SerializedName("stats") val stats: List<StatsDTO>
)
