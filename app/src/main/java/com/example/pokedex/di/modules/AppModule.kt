package com.example.pokedex.di.modules

import com.example.pokedex.network.remoteprovider.PokemonSearchRemoteProvider
import com.example.pokedex.network.remoteprovider.PokemonSearchRemoteProviderImpl
import com.example.pokedex.network.restclient.PokemonSearchRestClient
import com.example.pokedex.repository.PokemonSearchRepository
import com.example.pokedex.repository.PokemonSearchRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePokemonSearchRemoteProvider(
        pokemonSearchRestClient: PokemonSearchRestClient
    ): PokemonSearchRemoteProvider {
        return PokemonSearchRemoteProviderImpl(pokemonSearchRestClient)
    }

    @Provides
    @Singleton
    fun providePokemonSearchRepository(
        pokemonSearchRemoteProvider: PokemonSearchRemoteProvider
    ): PokemonSearchRepository {
        return PokemonSearchRepositoryImpl(pokemonSearchRemoteProvider)
    }
}