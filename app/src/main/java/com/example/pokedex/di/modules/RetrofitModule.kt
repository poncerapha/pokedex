package com.example.pokedex.di.modules

//@Module
//@InstallIn(SingletonComponent::class)
object RetrofitModule {

//    @Provides
//    @Singleton
//    fun provideRetrofit(client: OkHttpClient): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl("https://pokeapi.co/api/v2/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(client)
//            .build()
//    }
//
//    @Provides
//    @Singleton
//    fun providePokemonSearchRestClient(retrofit: Retrofit): PokemonSearchRestClient {
//        return retrofit.create(PokemonSearchRestClient::class.java)
//    }
//
//    @Provides
//    @Singleton
//    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
//        return HttpLoggingInterceptor().apply {
//            setLevel(HttpLoggingInterceptor.Level.BODY)
//        }
//    }
//
//    @Provides
//    @Singleton
//    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
//        return OkHttpClient.Builder()
//            .addInterceptor(loggingInterceptor)
//            .build()
//    }
}