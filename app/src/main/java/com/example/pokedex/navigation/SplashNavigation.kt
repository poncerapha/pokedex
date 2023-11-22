package com.example.pokedex.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.pokedex.screens.SplashScreen

internal const val splashScreenRoute = "splashScreen"

fun NavGraphBuilder.splashScreen(
    onNavigateToPokemonSearch: () -> Unit = {}
) {
    composable(
        route = splashScreenRoute
    ) {
        SplashScreen(
            onAnimationFinished = onNavigateToPokemonSearch
        )
    }
}