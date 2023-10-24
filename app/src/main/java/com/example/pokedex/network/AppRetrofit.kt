package com.example.pokedex.network

import com.example.pokedex.network.restclient.PokemonPageRestClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://pokeapi.co/api/v2/"

class AppRetrofit {
    private val client by lazy {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val pokemonPageRestClient: PokemonPageRestClient by lazy {
        retrofit.create(PokemonPageRestClient::class.java)
    }
}