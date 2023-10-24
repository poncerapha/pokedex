package com.example.pokedex.controller

import com.airbnb.epoxy.EpoxyController
import com.example.pokedex.models.Pokemon
import com.example.pokedex.ui.viewholders.pokemonHolder

class PokemonPageController: EpoxyController() {
    private var pokemon: Pokemon? = null
    override fun buildModels() {

        pokemon?.let {
            pokemonHolder {
                id("pokemon_${it.name}")
                pokemon(it)
            }
        }
    }

    fun setPokemon(pokemon: Pokemon) {
        this.pokemon = pokemon
        requestModelBuild()
    }
}