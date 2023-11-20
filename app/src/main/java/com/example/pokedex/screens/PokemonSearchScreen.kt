package com.example.pokedex.screens

import androidx.compose.foundation.Image
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.pokedex.R
import com.example.pokedex.models.PokemonCard
import com.example.pokedex.ui.components.ErrorMessage
import com.example.pokedex.ui.components.LoadingNextPageItem
import com.example.pokedex.ui.components.PageLoader
import com.example.pokedex.ui.components.PokemonSearchItem
import kotlinx.coroutines.flow.Flow

@Composable
fun PokemonSearchScreen(
    pokemonList: Flow<PagingData<PokemonCard>>,
    onPokemonCardClick: (pokemonName: String) -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(PaddingValues(horizontal = 16.dp)),
        contentAlignment = Alignment.Center
    ) {
        val pagingItems: LazyPagingItems<PokemonCard> = pokemonList.collectAsLazyPagingItems()

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

            Spacer(modifier = Modifier.height(8.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(PaddingValues(vertical = 8.dp)),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(
                    count = pagingItems.itemCount
                ) { index ->
                    val pokemon = pagingItems[index]!!
                    PokemonSearchItem(
                        pokemonCard = pokemon,
                        pokemonIndex = index + 1,
                        onPokemonCardClick = onPokemonCardClick
                    )
                }

                pagingItems.apply {
                    when {
                        loadState.refresh is LoadState.Loading -> {
                            item { PageLoader(modifier = Modifier.fillMaxSize()) }
                        }

                        loadState.refresh is LoadState.Error -> {
                            val error = pagingItems.loadState.refresh as LoadState.Error
                            item {
                                ErrorMessage(
                                    modifier = Modifier.fillMaxSize(),
                                    message = error.error.localizedMessage!!,
                                    onClickRetry = { retry() })
                            }
                        }

                        loadState.append is LoadState.Loading -> {
                            item { LoadingNextPageItem(modifier = Modifier) }
                        }

                        loadState.append is LoadState.Error -> {
                            val error = pagingItems.loadState.append as LoadState.Error
                            item {
                                ErrorMessage(
                                    modifier = Modifier,
                                    message = error.error.localizedMessage!!,
                                    onClickRetry = { retry() })
                            }
                        }
                    }
                }
            }
        }


    }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showSystemUi = true, name = "PokemonSearchScreen")
//@Composable
//fun PokemonSearchScreenPreview(uiState: UIState<List<PokemonCard>> = UIState.Success(listOf())) {
//    PokemonSearchScreen(uiState)
//}