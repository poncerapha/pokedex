package com.example.pokedex.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.constants.PokemonConstants.POKEMON_NAME_ARGUMENT
import com.example.pokedex.models.Pokemon
import com.example.pokedex.network.utils.UIState
import com.example.pokedex.network.utils.onError
import com.example.pokedex.network.utils.onSuccess
import com.example.pokedex.repository.PokemonPageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class PokemonPageViewModel @Inject constructor(
    private val pokemonPageRepository: PokemonPageRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _uiState = MutableStateFlow<UIState<Pokemon>>(UIState.Loading())
    val uiState: StateFlow<UIState<Pokemon>>
        get() = _uiState.asStateFlow()

    private val pokemonName: String? = savedStateHandle.get<String>(POKEMON_NAME_ARGUMENT)

    init {
        viewModelScope.launch {
            pokemonName?.let { pokemonName ->
                pokemonPageRepository.getPokemon(name = pokemonName)
                    .onSuccess {
                        _uiState.value = UIState.Success(it)
                    }
                    .onError {
                        _uiState.value = UIState.Error()
                    }
            }
        }
    }
}