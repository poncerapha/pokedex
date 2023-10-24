package com.example.pokedex.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pokedex.controller.PokemonSearchController
import com.example.pokedex.databinding.FragmentSearchPokemonBinding
import com.example.pokedex.network.UIState
import com.example.pokedex.viewmodel.PokemonSearchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchPokemonFragment: Fragment() {
    private lateinit var binding: FragmentSearchPokemonBinding
    private val epoxyController by lazy { PokemonSearchController() }
    private val pokemonSearchViewModel: PokemonSearchViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentSearchPokemonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupEpoxyController()
        pokemonSearchViewModel.getPokemonSearchList(150, 0)
        pokemonSearchViewModel.pokemonSearchList.observe(viewLifecycleOwner) {
            when(it) {
                is UIState.Success -> {
                    epoxyController.setPokemonList(it.data.results)
                }
                else -> {

                }
            }
        }

    }

    private fun setupEpoxyController() {
        binding.epoxyPokemonSearchFragment.apply {
            setController(epoxyController)
        }
    }
}