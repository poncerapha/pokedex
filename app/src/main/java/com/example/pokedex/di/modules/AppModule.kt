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
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun providePokemonSearchRestClient(retrofit: Retrofit): PokemonSearchRestClient {
        return retrofit.create(PokemonSearchRestClient::class.java)
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

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