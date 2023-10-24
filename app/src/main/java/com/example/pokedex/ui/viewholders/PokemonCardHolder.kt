package com.example.pokedex.ui.viewholders

import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.example.pokedex.databinding.HolderPokemonCardBinding
import com.example.pokedex.utils.BaseEpoxyModel

@EpoxyModelClass
abstract class PokemonCardHolder: BaseEpoxyModel<HolderPokemonCardBinding>(
    HolderPokemonCardBinding::inflate
) {
    @EpoxyAttribute
    lateinit var pokemonName: String

    override fun bind(binding: HolderPokemonCardBinding) {
        with(binding) {
            pokemonCardName.text = pokemonName
        }
    }
}