package com.example.pokedex.navigation

sealed class DestinationsPokedex(val route: String) {
    object SplashScreen : DestinationsPokedex("splashScreen")
    object PokemonListScreen : DestinationsPokedex("pokemonListScreen")
    object PokemonPageScreen : DestinationsPokedex("PokemonPageScreen")
}