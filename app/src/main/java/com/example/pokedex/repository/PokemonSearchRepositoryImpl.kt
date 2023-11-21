package com.example.pokedex.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.pokedex.data.PokemonSearchPagingSource
import com.example.pokedex.models.PokemonCard
import com.example.pokedex.network.restclient.PokemonSearchRestClient
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class PokemonSearchRepositoryImpl @Inject constructor(
    private val pokemonSearchRestClient: PokemonSearchRestClient
): PokemonSearchRepository {
    override fun getPokemonList(): Flow<PagingData<PokemonCard>> {
        return Pager(
            config = PagingConfig(pageSize = 1),
            pagingSourceFactory = { PokemonSearchPagingSource(pokemonSearchRestClient) }
        ).flow
    }
}