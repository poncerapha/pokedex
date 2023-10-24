package com.example.pokedex.di

import com.example.pokedex.repository.PokemonSearchRepository
import com.example.pokedex.repository.PokemonSearchRepositoryImpl
import com.example.pokedex.viewmodel.PokemonSearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object PokemonSearchDependencyInjectionModules {
    private val pokemonSearchModules = module {
        single<PokemonSearchRepository> { PokemonSearchRepositoryImpl() }
        viewModel { PokemonSearchViewModel() }
    }
    val modules = arrayOf(pokemonSearchModules)
}