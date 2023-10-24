package com.example.pokedex.models

data class PokemonSearch(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<Pokemon>
)
