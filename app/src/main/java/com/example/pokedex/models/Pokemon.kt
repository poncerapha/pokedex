package com.example.pokedex.models

data class Pokemon(
    val name: String,
    val sprites: Sprite,
    val moves: List<Moves>,
    val height: Int,
    val weight: Int
)
