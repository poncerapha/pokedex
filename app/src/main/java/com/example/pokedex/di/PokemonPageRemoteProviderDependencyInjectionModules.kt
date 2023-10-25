package com.example.pokedex.di

import com.example.pokedex.network.remoteprovider.PokemonPageRemoteProvider
import com.example.pokedex.network.remoteprovider.PokemonPageRemoteProviderImpl
import com.example.pokedex.viewmodel.PokemonPageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object PokemonPageRemoteProviderDependencyInjectionModules {
    private val pokemonPageModules = module {
        factory<PokemonPageRemoteProvider> { PokemonPageRemoteProviderImpl() }
    }
    val modules = arrayOf(pokemonPageModules)
}