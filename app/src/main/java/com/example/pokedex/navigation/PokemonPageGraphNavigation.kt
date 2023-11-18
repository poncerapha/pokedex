package com.example.pokedex.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.pokedex.screens.PokemonPageScreen
import com.example.pokedex.viewmodel.PokemonPageViewModel
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.pokemonPageGraph(
    navController: NavController
) {
    composable(
        route = DestinationsPokedex.PokemonPageScreen.route
    ) {
        val viewModel: PokemonPageViewModel = koinViewModel()
        val state by viewModel.uiState.collectAsState()
        PokemonPageScreen(state = state)
    }
}