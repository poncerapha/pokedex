package com.example.pokedex.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.pokedex.models.PokemonCard
import com.example.pokedex.utils.calcDominantColor

@Composable
fun PokemonSearchItem(
    pokemonCard: PokemonCard,
    onPokemonCardClick: (pokemonName: String) -> Unit = {},
    pokemonIndex: Int
) {
    val defaultDominantColor = MaterialTheme.colorScheme.surface
    var dominantColor by remember {
        mutableStateOf(defaultDominantColor)
    }
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier
            .size(120.dp)
            .clickable {
                onPokemonCardClick(
                    pokemonCard.name
                )
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            dominantColor,
                            defaultDominantColor
                        )
                    )
                )
        ) {
            Spacer(modifier = Modifier.size(8.dp))
            SubcomposeAsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/${pokemonIndex}.svg")
                    .decoderFactory(SvgDecoder.Factory()).build(),
                contentDescription = "pokemonImage",
                modifier = Modifier
                    .size(80.dp)
                    .align(Alignment.CenterHorizontally),
                loading = {
                    CircularProgressIndicator(
                        color = MaterialTheme.colorScheme.primary
                    )
                },
                onSuccess = { result ->
                    calcDominantColor(result.result.drawable) {
                        dominantColor = it
                    }
                }
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                textAlign = TextAlign.Center,
                text = pokemonCard.name,
                fontSize = 12.sp,
                fontWeight = FontWeight(400),
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}