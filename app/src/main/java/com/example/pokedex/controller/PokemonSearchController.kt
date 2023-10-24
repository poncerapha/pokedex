package com.example.pokedex.controller

import com.airbnb.epoxy.EpoxyController
import com.example.pokedex.models.Pokemon

class PokemonSearchController: EpoxyController() {
    private var pokemonList: List<Pokemon> = listOf()
    override fun buildModels() {

        pokemonList.forEach {
//            pokemonCardHolder()
            pokemonCardHolder(

            )
        }
    }


    fun setPokemonList(pokemonList: List<Pokemon>) {
        this.pokemonList = pokemonList
    }
}