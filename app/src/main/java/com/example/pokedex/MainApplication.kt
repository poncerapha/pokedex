package com.example.pokedex

import android.app.Application
import com.example.pokedex.di.PokemonPageDependencyInjectionModules
import com.example.pokedex.di.PokemonPageRemoteProviderDependencyInjectionModules
import com.example.pokedex.di.PokemonSearchDependencyInjectionModules
import com.example.pokedex.di.PokemonSearchRemoteProviderDependencyInjectionModules
import com.example.pokedex.utils.KoinUtils

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}