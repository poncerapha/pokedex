package com.example.pokedex.dto

import com.google.gson.annotations.SerializedName

class StatsDTO(
    @SerializedName("base_stat") val baseStat: Int,
    @SerializedName("effort") val effort: Int,
    @SerializedName("stat") val stat: StatDTO
)