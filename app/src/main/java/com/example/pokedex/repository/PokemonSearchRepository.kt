package com.example.pokedex.repository

import androidx.paging.PagingData
import com.example.pokedex.models.PokemonCard
import kotlinx.coroutines.flow.Flow

interface PokemonSearchRepository {
    fun getPokemonList(): Flow<PagingData<PokemonCard>>
}