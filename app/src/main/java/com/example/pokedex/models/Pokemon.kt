package com.example.pokedex.models

data class Pokemon(
    val name: String,
    val sprites: Sprite? = null,
    val moves: List<Moves>? = listOf(),
    val height: Int,
    val weight: Int,
    val id: Int,
    val types: List<Types>,
    val stats: List<Stats>
)
