package com.example.pokedex.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pokedex.constants.PokemonConstants.POKEMON_OFFSET
import com.example.pokedex.constants.PokemonConstants.POKEMON_STARTING_OFFSET
import com.example.pokedex.mappers.toPokemonCardModel
import com.example.pokedex.models.PokemonCard
import com.example.pokedex.network.restclient.PokemonSearchRestClient

class PokemonSearchPagingSource(
    private val pokemonSearchRestClient: PokemonSearchRestClient
) : PagingSource<Int, PokemonCard>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokemonCard> {
        val position = params.key ?: POKEMON_STARTING_OFFSET
        return try {
            val response = pokemonSearchRestClient.getPokemonList(
                position * POKEMON_OFFSET
            )
            val pokemons = mutableListOf<PokemonCard>()
            response.results.mapIndexed { index, pokemonCardDTO ->
                pokemons.add(pokemonCardDTO.toPokemonCardModel())
            }
            LoadResult.Page(
                data = pokemons,
                prevKey = if (position == 0) null else position,
                nextKey = if (position == response.count) null else position + 1
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, PokemonCard>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey
        }
    }
}