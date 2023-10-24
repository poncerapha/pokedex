package com.example.pokedex.controller

import com.airbnb.epoxy.EpoxyController
import com.example.pokedex.interfaces.PokemonSearchListener
import com.example.pokedex.models.PokemonCard
import com.example.pokedex.ui.viewholders.pokemonCardHolder

class PokemonSearchController(
    private val pokemonSearchListener: PokemonSearchListener
): EpoxyController() {
    private var pokemonList: List<PokemonCard> = listOf()
    override fun buildModels() {
        pokemonList.forEach {
            pokemonCardHolder {
                id("pokemon_card${it.name}")
                pokemonName(it.name)
                pokemonImageUrl(it.url)
                onPokemonCardClickListener {
                    this@PokemonSearchController.pokemonSearchListener.onPokemonCardClickListener(it)
                }
            }
        }
    }

    fun setPokemonList(pokemonList: List<PokemonCard>) {
        this.pokemonList = pokemonList
        requestModelBuild()
    }
}