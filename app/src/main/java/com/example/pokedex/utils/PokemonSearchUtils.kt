package com.example.pokedex.utils

import com.example.pokedex.models.PokemonCard
import com.example.pokedex.models.PokemonSearch

fun PokemonSearch.getPokemonImage(): List<PokemonCard> {
    val pokedexEntries = this.results.mapIndexed { index, entry ->
        val number = if (entry.url.endsWith("/")) {
            entry.url.dropLast(1).takeLastWhile { it.isDigit() }
        } else {
            entry.url.takeLastWhile { it.isDigit() }
        }
        val url =
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${number}.png"
        PokemonCard(entry.name.replaceFirstChar { it.toString() }, url, number)
    }
    return pokedexEntries
}
