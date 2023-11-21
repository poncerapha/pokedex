package com.example.pokedex.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.pokedex.screens.PokemonPageScreen
import com.example.pokedex.viewmodel.PokemonPageViewModel

internal const val pokemonPageRoute = "pokemonPage"
internal const val pokemonNameArgument = "pokemonName"

fun NavGraphBuilder.pokemonPageScreen() {
    composable(
        route = "$pokemonPageRoute/{$pokemonNameArgument}"
    ) {
        val viewModel: PokemonPageViewModel = hiltViewModel()
        val uIState by viewModel.uiState.collectAsState()
        PokemonPageScreen(uiState = uIState, Color.White)
    }
}

fun NavController.navigateToPokemonPage(pokemonName: String) {
    navigate("$pokemonPageRoute/$pokemonName")
}