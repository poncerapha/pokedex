package com.example.pokedex

import android.app.Application
import com.example.pokedex.di.PokemonPageDependencyInjectionModules
import com.example.pokedex.di.PokemonSearchDependencyInjectionModules
import com.example.pokedex.utils.KoinUtils

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        KoinUtils.createInstance(this@MainApplication)
        KoinUtils.addModules(*PokemonSearchDependencyInjectionModules.modules)
        KoinUtils.addModules(*PokemonPageDependencyInjectionModules.modules)
    }
}