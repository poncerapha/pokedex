package com.example.pokedex.interfaces

import com.example.pokedex.controller.BaseEpoxyPaginatedController

interface PokemonSearchListener: BaseEpoxyPaginatedController.EpoxyPaginatedControllerContract {
    fun onPokemonCardClickListener(name: String)
}