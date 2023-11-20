package com.example.pokedex.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.pokedex.screens.PokemonSearchScreen
import com.example.pokedex.viewmodel.PokemonSearchViewModel

internal const val pokemonSearchRoute = "pokemonSearch"

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.pokemonSearchScreen(
    onNavigateToPokemonPage: (pokemonName: String) -> Unit = {}
) {
    composable(
        route = pokemonSearchRoute
    ) {
        val viewModel = hiltViewModel<PokemonSearchViewModel>()
        val uiState by viewModel.uiState.collectAsState()

        PokemonSearchScreen(
            uiState = uiState,
            onPokemonCardClick = onNavigateToPokemonPage
        )
    }
}

fun NavController.navigateToPokemonSearch() {
    navigate(pokemonSearchRoute)
}
