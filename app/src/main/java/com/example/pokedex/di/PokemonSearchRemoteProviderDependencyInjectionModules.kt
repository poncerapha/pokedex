package com.example.pokedex.di

import android.text.Spannable.Factory
import com.example.pokedex.network.remoteprovider.PokemonSearchRemoteProvider
import com.example.pokedex.network.remoteprovider.PokemonSearchRemoteProviderImpl
import org.koin.dsl.module

object PokemonSearchRemoteProviderDependencyInjectionModules {
    private val pokemonSearchModules = module {
        factory<PokemonSearchRemoteProvider> { PokemonSearchRemoteProviderImpl() }
    }
    val modules = arrayOf(pokemonSearchModules)
}