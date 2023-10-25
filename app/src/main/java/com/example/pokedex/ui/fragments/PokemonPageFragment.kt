package com.example.pokedex.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.pokedex.controller.PokemonPageController
import com.example.pokedex.databinding.FragmentPokemonPageBinding
import com.example.pokedex.network.utils.UIState
import com.example.pokedex.viewmodel.PokemonPageViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonPageFragment : Fragment() {
    private lateinit var binding: FragmentPokemonPageBinding
    private val pokemonPageViewModel: PokemonPageViewModel by viewModel()
    private val epoxyController by lazy { PokemonPageController() }
    private val safeArgs by navArgs<PokemonPageFragmentArgs>()
    private val pokemonName by lazy {
        safeArgs.pokemonName
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentPokemonPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.epoxyPokemonPageFragment.apply {
            setController(epoxyController)
        }

        pokemonPageViewModel.getPokemon(pokemonName)
        pokemonPageViewModel.pokemon.observe(viewLifecycleOwner) {
            when(it) {
                is UIState.Success -> {
                    epoxyController.setPokemon(it.data)
                }
                else -> {

                }
            }
        }
    }
}