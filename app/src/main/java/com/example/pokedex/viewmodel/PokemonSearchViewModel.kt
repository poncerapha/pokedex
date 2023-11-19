package com.example.pokedex.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.models.PokemonCard
import com.example.pokedex.network.utils.UIState
import com.example.pokedex.network.utils.onSuccess
import com.example.pokedex.repository.PokemonSearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class PokemonSearchViewModel @Inject constructor(
    private val pokemonSearchRepository: PokemonSearchRepository
): ViewModel() {
    private val _uiState = MutableStateFlow<UIState<List<PokemonCard>>>(
        UIState.Loading()
    )
    val uiState get() = _uiState

    init {
        getPokemonList(20, 0)
    }

    private fun getPokemonList(limit: Int, offset: Int) {
        viewModelScope.launch {
            pokemonSearchRepository.getPokemonList(limit, offset)
                .onSuccess {
                    val pokemonItems = it.results.mapIndexed { index, pokemonCard ->
                        val number = index + 1
                        val url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/${number}.svg"
                        PokemonCard(
                            pokemonCard.name,
                            url,
                            number
                        )
                    }
                    _uiState.value = UIState.Success(pokemonItems)
                }
        }
    }
}