package com.example.pokedex.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.pokedex.models.PokemonCard
import com.example.pokedex.repository.PokemonSearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@HiltViewModel
class PokemonSearchViewModel @Inject constructor(
    pokemonSearchRepository: PokemonSearchRepository
) : ViewModel() {

    private val _pokemonListState: MutableStateFlow<PagingData<PokemonCard>> = MutableStateFlow(value = PagingData.empty())
    val pokemonListState: MutableStateFlow<PagingData<PokemonCard>> get() = _pokemonListState

    init {
        viewModelScope.launch {
            pokemonSearchRepository.getPokemonList()
                .distinctUntilChanged()
                .cachedIn(viewModelScope)
                .collect{
                    pokemonListState.value = it
                }
        }
    }
}