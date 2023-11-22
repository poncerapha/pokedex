package com.example.utils

import com.example.pokedex.models.Pokemon
import com.example.pokedex.models.Stat
import com.example.pokedex.models.Stats
import com.example.pokedex.models.Type
import com.example.pokedex.models.Types

val samplePokemon = Pokemon(
    name = "bulbasaur",
    height = 69,
    weight = 68,
    id = 1,
    types = listOf(
        Types(
            slot = 1,
            type = Type(
                name = "name",
                url = "url"
            )
        )
    ),
    stats = listOf(
        Stats(
            baseStat = 8,
            effort = 70,
            stat = Stat(
                name = "name",
                url = "url"
            )
        )
    )
)