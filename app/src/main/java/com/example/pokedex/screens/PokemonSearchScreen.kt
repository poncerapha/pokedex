package com.example.pokedex.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pokedex.models.PokemonCard
import com.example.pokedex.network.utils.UIState
import com.example.pokedex.ui.components.PokemonSearchItem

@Composable
fun PokemonSearchScreen(
    uiState: UIState<List<PokemonCard>>
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when(uiState) {
            is UIState.Loading -> {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.primary
                )
            }
            is UIState.Success -> {
                uiState.data?.let { pokemonList ->
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        contentPadding = PaddingValues(8.dp),
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        items(pokemonList) {
                            PokemonSearchItem(it)
                        }
                    }
                }
            } else -> {

            }
        }
    }
}

@Preview(showSystemUi = true, name = "PokemonSearchScreen")
@Composable
fun PokemonSearchScreenPreview(uiState: UIState<List<PokemonCard>> = UIState.Success(listOf())) {
    PokemonSearchScreen(uiState)
}