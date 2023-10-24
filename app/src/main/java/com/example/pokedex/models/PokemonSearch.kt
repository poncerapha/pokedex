package com.example.pokedex.models

data class PokemonSearch(
    val count: Int,
    val next: String,
    val results: List<Pokemon>
)
