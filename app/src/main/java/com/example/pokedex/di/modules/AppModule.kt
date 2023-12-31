package com.example.pokedex.di.modules

import com.example.pokedex.network.remoteprovider.PokemonPageRemoteProvider
import com.example.pokedex.network.remoteprovider.PokemonPageRemoteProviderImpl
import com.example.pokedex.network.restclient.PokemonPageRestClient
import com.example.pokedex.network.restclient.PokemonSearchRestClient
import com.example.pokedex.repository.PokemonPageRepository
import com.example.pokedex.repository.PokemonPageRepositoryImpl
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
    fun providePokemonSearchRepository(
        pokemonSearchRestClient: PokemonSearchRestClient
    ): PokemonSearchRepository {
        return PokemonSearchRepositoryImpl(pokemonSearchRestClient)
    }

    @Provides
    @Singleton
    fun providePokemonPageRemoteProvider(
        pokemonPageRestClient: PokemonPageRestClient
    ): PokemonPageRemoteProvider {
        return PokemonPageRemoteProviderImpl(pokemonPageRestClient)
    }

    @Provides
    @Singleton
    fun providePokemonPageRepository(
        pokemonPageRemoteProvider: PokemonPageRemoteProvider
    ): PokemonPageRepository {
        return PokemonPageRepositoryImpl(pokemonPageRemoteProvider)
    }
}