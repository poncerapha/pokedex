package com.example.pokedex.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.models.Pokemon
import com.example.pokedex.repository.PokemonPageRepository
import kotlinx.coroutines.launch

class PokemonPageViewModel(
    private val pokemonPageRepository: PokemonPageRepository
): ViewModel() {
    private val _pokemon = MutableLiveData<Pokemon>()
    val pokemon get() = _pokemon

    fun getPokemon(name: String) = viewModelScope.launch {
        pokemonPageRepository.getPokemon(
            name = name
        )
            .onSuccess {
                _pokemon.value = it
            }
            .onFailure {
                throw Exception(it)
            }
    }
}