package com.example.pokedex.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.constants.PokemonSearchConstants.POKEMON_SEARCH_LIMIT
import com.example.pokedex.models.PokemonCard
import com.example.pokedex.models.PokemonSearch
import com.example.pokedex.network.UIState
import com.example.pokedex.network.onError
import com.example.pokedex.network.onSuccess
import com.example.pokedex.repository.PokemonSearchRepository
import java.util.Locale
import kotlinx.coroutines.launch

class PokemonSearchViewModel(
    private val pokemonSearchRepository: PokemonSearchRepository
): ViewModel() {

    private val _pokemonSearchList = MutableLiveData<UIState<List<PokemonCard>>>()
    val pokemonSearchList get() = _pokemonSearchList

    fun getPokemonSearchList() = viewModelScope.launch {
        _pokemonSearchList.value = UIState.Loading()
        pokemonSearchRepository.getPokemonList(
            limit = POKEMON_SEARCH_LIMIT,
            offset = 0
        )
            .onSuccess {
                val pokemonImageUrl = pokemonCards(it)
                _pokemonSearchList.value = UIState.Success(pokemonImageUrl)
            }
            .onError {
                _pokemonSearchList.value = UIState.Error()
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
}