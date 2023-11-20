package com.example.pokedex.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.pokedex.screens.PokemonSearchScreen
import com.example.pokedex.viewmodel.PokemonSearchViewModel

internal const val pokemonSearchRoute = "pokemonSearch"

fun NavGraphBuilder.pokemonSearchScreen(
    onNavigateToPokemonPage: (pokemonName: String) -> Unit = {}
) {
    composable(
        route = pokemonSearchRoute
    ) {
        val viewModel = hiltViewModel<PokemonSearchViewModel>()

        PokemonSearchScreen(
            pokemonList = viewModel.pokemonListState,
            onPokemonCardClick = onNavigateToPokemonPage
        )
    }
}

fun NavController.navigateToPokemonSearch() {
    navigate(pokemonSearchRoute)
}
