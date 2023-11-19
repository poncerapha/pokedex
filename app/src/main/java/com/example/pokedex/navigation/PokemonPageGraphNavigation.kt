package com.example.pokedex.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.pokemonPageGraph(
    navController: NavController
) {
    composable(
        route = DestinationsPokedex.PokemonPageScreen.route
    ) {
//        val viewModel: PokemonPageViewModel = hiltViewModel()
//        val state by viewModel.uiState.collectAsState()
//        PokemonPageScreen(state = state)
    }
}