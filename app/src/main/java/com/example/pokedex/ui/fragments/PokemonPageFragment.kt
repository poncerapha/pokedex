package com.example.pokedex.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pokedex.databinding.FragmentPokemonPageBinding
import com.example.pokedex.network.UIState
import com.example.pokedex.network.data
import com.example.pokedex.viewmodel.PokemonPageViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonPageFragment : Fragment() {
    private lateinit var binding: FragmentPokemonPageBinding
    private val pokemonPageViewModel: PokemonPageViewModel by viewModel()

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

        pokemonPageViewModel.getPokemon("bulbasaur")

        pokemonPageViewModel.pokemon.observe(viewLifecycleOwner) {
            when(it) {
                is UIState.Success -> {
                    binding.pokemonName.text = it.data.name
                }
                else -> {

                }
            }
        }
    }
}