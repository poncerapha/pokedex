package com.example.pokedex.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.models.PokemonSearchCard
import com.example.pokedex.repository.PokemonSearchRepository
import kotlinx.coroutines.launch

class PokemonSearchViewModel(
    private val pokemonSearchRepository: PokemonSearchRepository
): ViewModel() {

    private val _pokemonSearchList = MutableLiveData<PokemonSearchCard>()
    val pokemonSearchList get() = _pokemonSearchList

    fun getPokemonSearchList(limit: Int, offset: Int) = viewModelScope.launch {
        pokemonSearchRepository.getPokemonList(
            limit = limit,
            offset = offset
        )
//            .onSuccess {
//                _pokemonSearchList.value = it
//            }
//            .onFailure {
//                throw Exception(it)
//            }
    }
}