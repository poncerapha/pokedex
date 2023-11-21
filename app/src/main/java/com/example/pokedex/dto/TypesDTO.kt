package com.example.pokedex.dto

import com.google.gson.annotations.SerializedName

data class TypesDTO(
    @SerializedName("slot") val slot: Int,
    @SerializedName("type") val type: TypeDTO
)