package com.example.pokedex.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.constants.PokemonSearchConstants.POKEMON_SEARCH_LIMIT
import com.example.pokedex.models.PokemonCard
import com.example.pokedex.models.PokemonSearch
import com.example.pokedex.network.UIPagingState
import com.example.pokedex.network.data
import com.example.pokedex.network.onError
import com.example.pokedex.network.onSuccess
import com.example.pokedex.repository.PokemonSearchRepository
import kotlinx.coroutines.launch

class PokemonSearchViewModel(
    private val pokemonSearchRepository: PokemonSearchRepository
): ViewModel() {
    private val _pokemonSearchList = MutableLiveData<UIPagingState<List<PokemonCard>>>()
    val pokemonSearchList get() = _pokemonSearchList

    private val _pokemonList = mutableListOf<PokemonCard>()
    val pokemonList: List<PokemonCard> get() = _pokemonList
    private var offset = 0
    private var limit = 20

    fun getPokemonSearchList() = viewModelScope.launch {
        val isPaging = offset != 0
        _pokemonSearchList.value = if (isPaging) {
            UIPagingState.PagingLoading()
        } else {
            UIPagingState.Loading()
        }
        pokemonSearchRepository.getPokemonList(
            limit = limit,
            offset = offset
        )
            .onSuccess {
                it.results.let { pokemonList ->
                    val pokemonCardsWithImage = pokemonCards(it)
                    _pokemonList.addAll(pokemonCardsWithImage)
                }
                if (_pokemonList.isEmpty()) {
//                    _pokemonSearchList.value = StateEmptySearch(it)
                } else {
                    _pokemonSearchList.value = UIPagingState.Success(it.results)
                    offset += POKEMON_SEARCH_LIMIT
                    limit += 20
                }
            }
            .onError {
                _pokemonSearchList.value = UIPagingState.Error()
            }
    }

    private fun pokemonCards(it: PokemonSearch): List<PokemonCard> {
        val pokedexEntries = it.results.mapIndexed { index, entry ->
            val number = if (entry.url.endsWith("/")) {
                entry.url.dropLast(1).takeLastWhile { it.isDigit() }
            } else {
                entry.url.takeLastWhile { it.isDigit() }
            }
            val url =
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${number}.png"
            PokemonCard(entry.name.replaceFirstChar { it.toString() }, url, number)
        }
        return pokedexEntries
    }

    fun isLastPage(): Boolean {
        return offset + POKEMON_SEARCH_LIMIT >= 1000
    }
}