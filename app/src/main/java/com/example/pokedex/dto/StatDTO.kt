package com.example.pokedex.dto

import com.google.gson.annotations.SerializedName

class StatDTO(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)
