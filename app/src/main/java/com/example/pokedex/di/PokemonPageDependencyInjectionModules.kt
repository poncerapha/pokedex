package com.example.pokedex.di

import com.example.pokedex.repository.PokemonPageRepository
import com.example.pokedex.repository.PokemonPageRepositoryImpl
import com.example.pokedex.viewmodel.PokemonPageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object PokemonPageDependencyInjectionModules {
    private val pokemonPageModules = module {
        factory<PokemonPageRepository> { PokemonPageRepositoryImpl(get()) }
        viewModel { PokemonPageViewModel(pokemonPageRepository = get()) }
    }
    val modules = arrayOf(pokemonPageModules)
}