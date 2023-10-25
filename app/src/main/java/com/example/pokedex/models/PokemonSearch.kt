package com.example.pokedex.models

data class PokemonSearch(
    val count: Int = 0,
    val next: String = "",
    var results: List<PokemonCard> = listOf(),
    var isLastPage: Boolean = false
)
