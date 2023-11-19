package com.example.pokedex.navigation

sealed class DestinationsPokedex(val route: String) {
    object SplashScreen : DestinationsPokedex("splashScreen")
    object PokemonSearchScreen : DestinationsPokedex("pokemonSearchScreen")
    object PokemonPageScreen : DestinationsPokedex("PokemonPageScreen")
}