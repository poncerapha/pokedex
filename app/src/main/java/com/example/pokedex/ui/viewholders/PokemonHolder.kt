package com.example.pokedex.ui.viewholders

import coil.decode.SvgDecoder
import coil.load
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.example.pokedex.R
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
            setupPokemonImage()
            setupPokemonInfo()
        }
    }

    private fun HolderPokemonBinding.setupPokemonImage() {
        pokemonImage.load(pokemon.sprites.others.dreamWorld.frontDefault) {
            decoderFactory { result, options, _ -> SvgDecoder(result.source, options) }
        }
    }

    private fun HolderPokemonBinding.setupPokemonInfo() {
        pokemonName.text = pokemon.name
        pokemonHeight.apply {
            text = this.context.getString(R.string.pokemon_height, pokemon.height.toString())
        }
        pokemonWeight.apply {
            text = this.context.getString(R.string.pokemon_weight, pokemon.weight.toString())
        }
    }
}