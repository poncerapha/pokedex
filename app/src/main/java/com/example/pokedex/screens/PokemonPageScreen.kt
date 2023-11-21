package com.example.pokedex.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.pokedex.R
import com.example.pokedex.models.Pokemon
import com.example.pokedex.ui.components.PokemonDetailTopSection
import com.example.pokedex.ui.components.PokemonDetailsStateWrapper
import com.example.pokedex.utils.UIState

@Composable
fun PokemonPageScreen(
    uiState: UIState<Pokemon>,
    dominantColor: Color = Color.White,
    onBackStackClick: () -> Unit
) {
    val defaultDominantColor = MaterialTheme.colorScheme.surface
    val topPadding = 16.dp
    val pokemonImageSize = 150.dp
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(dominantColor)
            .padding(bottom = 16.dp)
    ) {
        PokemonDetailTopSection(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
                .align(Alignment.TopCenter),
            onBackStackClick = onBackStackClick
        )

        PokemonDetailsStateWrapper(
            uiState = uiState,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = topPadding + pokemonImageSize / 2f,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
                .shadow(10.dp, RoundedCornerShape(10.dp))
                .clip(RoundedCornerShape(10.dp))
                .background(MaterialTheme.colorScheme.surface)
                .padding(16.dp)
                .align(Alignment.BottomCenter),
            loadingModifier = Modifier
                .size(100.dp)
                .align(Alignment.Center)
                .padding(
                    top = topPadding + pokemonImageSize / 2f,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
        )
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .fillMaxSize()
        ) {
            if (uiState is UIState.Success) {
                uiState.data.sprites?.let {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(it.others.dreamWorld.frontDefault)
                            .decoderFactory(SvgDecoder.Factory()).build(),
                        contentDescription = "pokemonImage",
                        Modifier
                            .size(pokemonImageSize)
                            .offset(y = topPadding),
                        placeholder = painterResource(id = R.drawable.ic_placeholder)
                    )
                }
            }
        }
    }
}

//@Preview(showSystemUi = true)
//@Composable
//fun PokemonPageScreenPreview() {
//    PokemonPageScreen(UIState.Success(
//        samplePokemon
//    ))
//}