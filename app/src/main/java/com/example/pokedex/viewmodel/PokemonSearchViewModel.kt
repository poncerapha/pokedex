package com.example.pokedex.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.constants.PokemonSearchConstants.INITIAL_OFFSET
import com.example.pokedex.constants.PokemonSearchConstants.POKEMON_SEARCH_LIMIT
import com.example.pokedex.models.PokemonCard
import com.example.pokedex.network.utils.UIPagingState
import com.example.pokedex.network.utils.onError
import com.example.pokedex.network.utils.onSuccess
import com.example.pokedex.repository.PokemonSearchRepository
import com.example.pokedex.utils.getPokemonImage
import kotlinx.coroutines.launch

class PokemonSearchViewModel(
    private val pokemonSearchRepository: PokemonSearchRepository
): ViewModel() {
    private val _pokemonSearchList = MutableLiveData<UIPagingState<List<PokemonCard>>>()
    val pokemonSearchList get() = _pokemonSearchList

    private val _pokemonList = mutableListOf<PokemonCard>()
    val pokemonList: List<PokemonCard> get() = _pokemonList

    private var offset = INITIAL_OFFSET
    private var limit = POKEMON_SEARCH_LIMIT
    private var pokedexTotalCount: Int = 0

    fun getPokemonSearchList() = viewModelScope.launch {
        val isPaging = offset != INITIAL_OFFSET
        _pokemonSearchList.value = if (isPaging) {
            UIPagingState.PagingLoading()
        } else {
            UIPagingState.Loading()
        }
        pokemonSearchRepository.getPokemonList(
            limit = limit,
            offset = offset
        )
            .onSuccess { pokemonSearch ->
                pokedexTotalCount = pokemonSearch.count
                _pokemonList.addAll(pokemonSearch.getPokemonImage())
                _pokemonSearchList.value = UIPagingState.Success(pokemonSearch.results)
                offset += POKEMON_SEARCH_LIMIT
                limit += POKEMON_SEARCH_LIMIT
            }
            .onError {
                _pokemonSearchList.value = UIPagingState.Error()
            }
    }

    fun isLastPage(): Boolean {
        return offset + POKEMON_SEARCH_LIMIT >= pokedexTotalCount
    }
}