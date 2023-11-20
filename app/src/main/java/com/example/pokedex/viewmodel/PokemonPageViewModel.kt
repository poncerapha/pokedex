package com.example.pokedex.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.models.Pokemon
import com.example.pokedex.navigation.pokemonNameArgument
import com.example.pokedex.network.utils.onSuccess
import com.example.pokedex.repository.PokemonPageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

@HiltViewModel
class PokemonPageViewModel @Inject constructor(
    private val pokemonPageRepository: PokemonPageRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _uiState = MutableStateFlow(Pokemon())
    val uiState: StateFlow<Pokemon>
        get() = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            savedStateHandle
                .getStateFlow<String?>(pokemonNameArgument, null)
                .filterNotNull()
                .collect { pokemonName ->
                    pokemonPageRepository.getPokemon(name = pokemonName)
                        .onSuccess {
                            _uiState.value = uiState.value.copy(
                                name = it.name,
                                sprites = it.sprites,
                                moves = it.moves,
                                height = it.height,
                                weight = it.weight,
                                order = it.order
                            )
                        }
                }
        }
    }
}