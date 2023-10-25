package com.example.pokedex.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.pokedex.controller.PokemonSearchController
import com.example.pokedex.databinding.FragmentSearchPokemonBinding
import com.example.pokedex.interfaces.PokemonSearchListener
import com.example.pokedex.network.UIPagingState
import com.example.pokedex.network.UIState
import com.example.pokedex.network.data
import com.example.pokedex.viewmodel.PokemonSearchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchPokemonFragment: Fragment(), PokemonSearchListener {
    private lateinit var binding: FragmentSearchPokemonBinding
    private val epoxyController by lazy { PokemonSearchController(this) }
    private val pokemonSearchViewModel: PokemonSearchViewModel by viewModel()
    private val navController by lazy { findNavController() }

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
        pokemonSearchViewModel.getPokemonSearchList()
        pokemonSearchViewModel.pokemonSearchList.observe(viewLifecycleOwner) {
            when(it) {
                is UIPagingState.Success -> {
                    epoxyController.updatePaginatedList(pokemonSearchViewModel.pokemonList)
                    epoxyController.setIsLastPage(pokemonSearchViewModel.isLastPage())
                }
                is UIPagingState.PagingLoading, is UIPagingState.Loading -> {
                    println()
                }

                is UIPagingState.Error -> {
                    println()
                }

                else -> {
                    println()
                }
            }
        }
    }

    private fun setupEpoxyController() {
        binding.epoxyPokemonSearchFragment.apply {
            setController(epoxyController)
        }
    }

    override fun onPokemonCardClickListener(name: String) {
        val direction = SearchPokemonFragmentDirections
            .actionSearchPokemonFragmentToPokemonPageFragment(name)
        navController.navigate(direction)
    }

    override fun loadMore() {
        pokemonSearchViewModel.getPokemonSearchList()
        epoxyController.isLoading = true
    }
}