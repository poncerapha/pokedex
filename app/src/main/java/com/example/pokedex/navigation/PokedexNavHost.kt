package com.example.pokedex.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun PokedexNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = splashScreenRoute
    ) {
        splashScreen(
            onNavigateToPokemonSearch = {
                navController.navigateToPokemonSearch()
            }
        )
        pokemonSearchScreen(
            onNavigateToPokemonPage = { pokemonName ->  
                navController.navigateToPokemonPage(pokemonName)
            }
        )
        pokemonPageScreen(
            onNavigateToPokemonSearch = {
                navController.navigateUp()
            }
        )
    }
}