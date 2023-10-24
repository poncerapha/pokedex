package com.example.pokedex.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.models.PokemonSearch
import com.example.pokedex.network.UIState
import com.example.pokedex.network.onError
import com.example.pokedex.network.onSuccess
import com.example.pokedex.repository.PokemonSearchRepository
import kotlinx.coroutines.launch

class PokemonSearchViewModel(
    private val pokemonSearchRepository: PokemonSearchRepository
): ViewModel() {

    private val _pokemonSearchList = MutableLiveData<UIState<PokemonSearch>>()
    val pokemonSearchList get() = _pokemonSearchList

    fun getPokemonSearchList(limit: Int, offset: Int) = viewModelScope.launch {
        _pokemonSearchList.value = UIState.Loading()
        pokemonSearchRepository.getPokemonList(
            limit = limit,
            offset = offset
        )
            .onSuccess {
                _pokemonSearchList.value = UIState.Success(it)
            }
            .onError {
                _pokemonSearchList.value = UIState.Error()
            }
    }
}