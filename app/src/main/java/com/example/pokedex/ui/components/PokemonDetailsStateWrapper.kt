package com.example.pokedex.ui.components

import androidx.compose.foundation.layout.offset
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokedex.models.Pokemon
import com.example.pokedex.utils.UIState

@Composable
fun PokemonDetailsStateWrapper(
    uiState: UIState<Pokemon>,
    modifier: Modifier = Modifier,
    loadingModifier: Modifier = Modifier
) {
    when (uiState) {
        is UIState.Success -> {
            PokemonDetailSection(
                pokemon = uiState.data,
                modifier = modifier
                    .offset(y = (-20).dp)
            )
        }

        is UIState.Error -> {
            uiState.errorData?.message?.let {
                Text(
                    text = it,
                    color = Color.Red,
                    modifier = modifier
                )
            }
        }

        is UIState.Loading -> {
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.primary,
                modifier = loadingModifier
            )
        }
    }
}