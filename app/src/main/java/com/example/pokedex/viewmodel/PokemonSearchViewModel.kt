package com.example.pokedex.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.pokedex.repository.PokemonSearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonSearchViewModel @Inject constructor(
    pokemonSearchRepository: PokemonSearchRepository
) : ViewModel() {

    val pokemonList = pokemonSearchRepository.getPokemonList().cachedIn(viewModelScope)
}