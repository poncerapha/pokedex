package com.example.pokedex.ui.viewholders

import coil.decode.SvgDecoder
import coil.load
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.example.pokedex.databinding.HolderPokemonBinding
import com.example.pokedex.models.Pokemon
import com.example.pokedex.utils.BaseEpoxyModel

@EpoxyModelClass
abstract class PokemonHolder: BaseEpoxyModel<HolderPokemonBinding>(
    HolderPokemonBinding::inflate
) {
    @EpoxyAttribute
    lateinit var pokemon: Pokemon

    override fun bind(binding: HolderPokemonBinding) {
        with(binding) {

            pokemonImage.load(pokemon.sprites.others.dreamWorld.frontDefault) {
                decoderFactory { result, options, _ -> SvgDecoder(result.source, options) }
            }

            pokemonText.text = pokemon.name
        }
    }
}