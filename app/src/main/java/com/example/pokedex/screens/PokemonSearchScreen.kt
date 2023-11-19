package com.example.pokedex.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pokedex.R
import com.example.pokedex.models.PokemonCard
import com.example.pokedex.network.utils.UIState
import com.example.pokedex.ui.components.PokemonSearchItem

@ExperimentalMaterial3Api
@Composable
fun PokemonSearchScreen(
    uiState: UIState<List<PokemonCard>>
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(PaddingValues(horizontal = 16.dp)),
        contentAlignment = Alignment.Center
    ) {
        when (uiState) {
            is UIState.Loading -> {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.primary
                )
            }

            is UIState.Success -> {
                val currentFocus = LocalFocusManager.current
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_pokemon_logo),
                        contentDescription = "pokemonLogo",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxWidth()
                            .scale(0.8f),
                        alignment = Alignment.Center
                    )

                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null
                            )
                        },
                        value = "value",
                        onValueChange = { },
                        label = { Text("teste") },
                        keyboardOptions = KeyboardOptions(
                            capitalization = KeyboardCapitalization.Words,
                            imeAction = ImeAction.Next
                        ),
                        keyboardActions = (KeyboardActions(onNext = {
                            currentFocus.moveFocus(
                                FocusDirection.Next
                            )
                        }))
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(PaddingValues(vertical = 8.dp)),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        items(uiState.data) {
                            PokemonSearchItem(it)
                        }
                    }
                }
            }

            else -> {

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true, name = "PokemonSearchScreen")
@Composable
fun PokemonSearchScreenPreview(uiState: UIState<List<PokemonCard>> = UIState.Success(listOf())) {
    PokemonSearchScreen(uiState)
}