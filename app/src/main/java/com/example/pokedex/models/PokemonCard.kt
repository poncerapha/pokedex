package com.example.pokedex.models

data class PokemonCard(
    val name: String,
    val url: String,
    val pokemonImage: String = ""
)