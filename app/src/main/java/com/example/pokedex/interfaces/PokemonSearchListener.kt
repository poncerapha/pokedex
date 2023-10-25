package com.example.pokedex.interfaces


interface PokemonSearchListener: EpoxyPaginatedControllerContract {
    fun onPokemonCardClickListener(name: String)
}