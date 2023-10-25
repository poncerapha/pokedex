package com.example.pokedex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pokedex.di.PokemonPageDependencyInjectionModules
import com.example.pokedex.di.PokemonPageRemoteProviderDependencyInjectionModules
import com.example.pokedex.di.PokemonSearchDependencyInjectionModules
import com.example.pokedex.di.PokemonSearchRemoteProviderDependencyInjectionModules
import com.example.pokedex.utils.KoinUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }
}