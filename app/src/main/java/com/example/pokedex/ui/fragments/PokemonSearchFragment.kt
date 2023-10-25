package com.example.pokedex.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.pokedex.controller.PokemonSearchController
import com.example.pokedex.databinding.FragmentPokemonSearchBinding
import com.example.pokedex.interfaces.PokemonSearchListener
import com.example.pokedex.models.PokemonCard
import com.example.pokedex.network.utils.UIPagingState
import com.example.pokedex.viewmodel.PokemonSearchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonSearchFragment: Fragment(), PokemonSearchListener {
    private lateinit var binding: FragmentPokemonSearchBinding
    private val epoxyController by lazy { PokemonSearchController(this) }
    private val pokemonSearchViewModel: PokemonSearchViewModel by viewModel()
    private val navController by lazy { findNavController() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentPokemonSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupEpoxyController()
        pokemonSearchViewModel.getPokemonSearchList()
        pokemonSearchViewModel.pokemonSearchList.observe(viewLifecycleOwner) {
            handlePokemonCardStates(it)
        }
    }

    private fun handlePokemonCardStates(it: UIPagingState<List<PokemonCard>>) {
        when (it) {
            is UIPagingState.Success -> processSuccessState()
            is UIPagingState.Error, is UIPagingState.PagingError -> processErrorState()
            is UIPagingState.PagingLoading, is UIPagingState.Loading -> processLoadingState()
        }
    }

    private fun processSuccessState() {
        binding.pokemonCardShimmer.root.isVisible = false
        epoxyController.updatePaginatedList(pokemonSearchViewModel.pokemonList)
        epoxyController.setIsLastPage(pokemonSearchViewModel.isLastPage())
    }

    private fun processErrorState() {
        binding.pokemonCardShimmer.root.isVisible = false
    }

    private fun processLoadingState() {
        binding.pokemonCardShimmer.root.isVisible = true
    }

    private fun setupEpoxyController() {
        binding.epoxyPokemonSearchFragment.apply {
            setController(epoxyController)
        }
    }

    override fun onPokemonCardClickListener(name: String) {
        val direction = PokemonSearchFragmentDirections
            .actionSearchPokemonFragmentToPokemonPageFragment(name)
        navController.navigate(direction)
    }

    override fun loadMore() {
        pokemonSearchViewModel.getPokemonSearchList()
        epoxyController.setLoading()
    }
}