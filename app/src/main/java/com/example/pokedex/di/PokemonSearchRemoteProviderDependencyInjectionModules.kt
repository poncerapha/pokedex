package com.example.pokedex.di

import com.example.pokedex.network.remoteprovider.PokemonSearchRemoteProvider
import com.example.pokedex.network.remoteprovider.PokemonSearchRemoteProviderImpl
import org.koin.dsl.module

object PokemonSearchRemoteProviderDependencyInjectionModules {
    private val pokemonPageModules = module {
        factory<PokemonSearchRemoteProvider> { PokemonSearchRemoteProviderImpl(get()) }
    }
    val modules = arrayOf(pokemonPageModules)
}