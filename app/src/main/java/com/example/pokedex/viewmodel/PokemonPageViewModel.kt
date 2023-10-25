package com.example.pokedex.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.models.Pokemon
import com.example.pokedex.network.utils.UIState
import com.example.pokedex.network.utils.onError
import com.example.pokedex.network.utils.onSuccess
import com.example.pokedex.repository.PokemonPageRepository
import kotlinx.coroutines.launch

class PokemonPageViewModel(
    private val pokemonPageRepository: PokemonPageRepository
): ViewModel() {
    private val _pokemon = MutableLiveData<UIState<Pokemon>>()
    val pokemon get() = _pokemon

    fun getPokemon(name: String) = viewModelScope.launch {
        _pokemon.value = UIState.Loading()
        pokemonPageRepository.getPokemon(
            name = name
        )
            .onSuccess {
                _pokemon.value = UIState.Success(it)
            }
            .onError {
                _pokemon.value = UIState.Error()
            }
    }
}