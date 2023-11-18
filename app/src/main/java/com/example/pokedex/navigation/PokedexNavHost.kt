package com.example.pokedex.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.pokedex.navigation.DestinationsPokedex.*

@Composable
fun PokedexNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = PokemonPageScreen.route
    ) {
        splashGraph(navController)
        pokemonListGraph(navController)
        pokemonPageGraph(navController)
    }
}