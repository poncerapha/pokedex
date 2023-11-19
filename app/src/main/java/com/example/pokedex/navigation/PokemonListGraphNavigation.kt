package com.example.pokedex.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.pokedex.screens.PokemonSearchScreen
import com.example.pokedex.viewmodel.PokemonSearchViewModel

fun NavGraphBuilder.pokemonListGraph(
) {
    composable(
        route = DestinationsPokedex.PokemonSearchScreen.route
    ) {
        val viewModel = hiltViewModel<PokemonSearchViewModel>()
        val uiState by viewModel.uiState.collectAsState()
        val changeLayout: Boolean = false

        PokemonSearchScreen(
            uiState
        )
    }
}
