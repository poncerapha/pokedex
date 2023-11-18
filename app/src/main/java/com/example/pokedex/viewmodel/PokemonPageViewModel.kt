package com.example.pokedex.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.models.PokemonUiState
import com.example.pokedex.network.utils.onSuccess
import com.example.pokedex.repository.PokemonPageRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PokemonPageViewModel(
    private val pokemonPageRepository: PokemonPageRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(PokemonUiState())
    val uiState: StateFlow<PokemonUiState>
        get() = _uiState.asStateFlow()

    suspend fun getPokemon(name: String) = viewModelScope.launch {
        pokemonPageRepository.getPokemon(
            name = name
        )
            .onSuccess {
                _uiState.value = uiState.value.copy(
                    name = it.name,
                    sprites = it.sprites,
                    moves = it.moves,
                    height = it.height,
                    weight = it.weight
                )
            }
    }
}