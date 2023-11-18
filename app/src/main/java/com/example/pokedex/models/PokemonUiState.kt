package com.example.pokedex.models

data class PokemonUiState(
    val name: String = "",
    val sprites: Sprite? = null,
    val moves: List<Moves> = listOf(),
    val height: Int = 0,
    val weight: Int = 0
)
