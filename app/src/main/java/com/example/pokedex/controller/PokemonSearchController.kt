package com.example.pokedex.controller

import com.airbnb.epoxy.EpoxyController
import com.example.pokedex.interfaces.PokemonSearchListener
import com.example.pokedex.models.PokemonCard
import com.example.pokedex.ui.viewholders.pokemonCardHolder

class PokemonSearchController(
    private val pokemonSearchListener: PokemonSearchListener
): EpoxyPaginatedController<PokemonCard>(pokemonSearchListener) {
    override fun renderPaginatedHolder(item: PokemonCard, index: Int) {
        pokemonCardHolder {
            id("pokemon_card${item.name}")
            pokemonName(item.name)
            pokemonImageUrl(item.url)
            onPokemonCardClickListener {
                this@PokemonSearchController.pokemonSearchListener.onPokemonCardClickListener(it)
            }
        }
    }

    override fun shouldLoadMore(): Boolean = !isLastPage
}