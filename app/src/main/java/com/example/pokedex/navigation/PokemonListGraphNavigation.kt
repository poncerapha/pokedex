package com.example.pokedex.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.pokedex.network.utils.data
import com.example.pokedex.viewmodel.PokemonSearchViewModel

fun NavGraphBuilder.pokemonListGraph(
    navController: NavController
) {
    composable(
        route = DestinationsPokedex.PokemonSearchScreen.route
    ) {
        val viewModel = hiltViewModel<PokemonSearchViewModel>()
        val uiState by viewModel.uiState.collectAsState()

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            uiState.data?.let {
                Text(text = it.first().name)
            }
        }
    }
}