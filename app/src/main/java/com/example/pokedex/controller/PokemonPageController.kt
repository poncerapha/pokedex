package com.example.pokedex.controller

import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.group
import com.example.pokedex.R
import com.example.pokedex.models.Pokemon
import com.example.pokedex.ui.viewholders.pokemonHolder
import com.example.pokedex.ui.viewholders.textViewHolder

class PokemonPageController: EpoxyController() {
    private var pokemon: Pokemon? = null
    override fun buildModels() {

        pokemon?.let { pokemon ->
            pokemonHolder {
                id("pokemon_${pokemon.name}")
                pokemon(pokemon)
            }

            group {
                id("pokemon_move_group${pokemon.name}")
                layout(R.layout.group_pokemon_move)

                pokemon.moves.forEachIndexed{ index, moves ->
                    textViewHolder {
                        id("pokemon_move${moves.move.name}")
                        text(moves.move.name)
                        shouldShowDivider(index != pokemon.moves.size)
                    }
                }
            }
        }
    }

    fun setPokemon(pokemon: Pokemon) {
        this.pokemon = pokemon
        requestModelBuild()
    }
}