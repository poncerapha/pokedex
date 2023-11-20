package com.example.pokedex.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pokedex.mappers.toPokemonCardModel
import com.example.pokedex.models.PokemonCard
import com.example.pokedex.network.restclient.PokemonSearchRestClient

const val POKEMON_STARTING_OFFSET = 0
const val POKEMON_OFFSET = 20
const val LAST_OFFSET = 885
const val LAST_POSITION = 45

class PokemonSearchPagingSource(
    private val pokemonSearchRestClient: PokemonSearchRestClient
) : PagingSource<Int, PokemonCard>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokemonCard> {
        val position = params.key ?: POKEMON_STARTING_OFFSET
        return try {
            val response = pokemonSearchRestClient.getPokemonList(
                if (position == LAST_POSITION) {
                    LAST_OFFSET
                } else {
                    position * POKEMON_OFFSET
                }
            )
            val pokemons = mutableListOf<PokemonCard>()
            response.results.mapIndexed { index, pokemonCardDTO ->
                pokemons.add(pokemonCardDTO.toPokemonCardModel())
            }
            LoadResult.Page(
                data = pokemons,
                prevKey = if (position == 0) null else position,
                nextKey = if (position == LAST_POSITION) null else position + 1
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