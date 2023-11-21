package com.example.pokedex.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.pokedex.R
import com.example.pokedex.models.Pokemon
import com.example.pokedex.models.Types
import com.example.pokedex.utils.UIState
import com.example.pokedex.utils.parseStatToAbbr
import com.example.pokedex.utils.parseStatToColor
import com.example.pokedex.utils.parseTypeToColor
import java.lang.Math.round

@Composable
fun PokemonPageScreen(
    uiState: UIState<Pokemon>,
    dominantColor: Color,
    onBackStackClick: () -> Unit = {}
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
                .align(Alignment.TopStart)
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


//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(
//                Brush.verticalGradient(
//                    listOf(
//                        dominantColor,
//                        defaultDominantColor
//                    )
//                )
//            )
//            .padding(16.dp)
//    ) {
//        Column(
//            modifier = Modifier.fillMaxWidth(),
//            verticalArrangement = Arrangement.spacedBy(4.dp)
//        ) {
//            Row(
//                Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(
//                    text = pokemon.name,
//                    fontSize = 20.sp,
//                    fontWeight = FontWeight(500)
//                )
//                Text(
//                    text = "#001",
//                    fontSize = 20.sp,
//                    fontWeight = FontWeight(500),
//                )
//            }
//            Row(
//                Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(text = "Grass")
//                Text(text = "Seed Pokemon")
//            }
//
//            Box(
//                modifier = Modifier.fillMaxWidth(),
//                contentAlignment = Alignment.Center
//            ) {
//                AsyncImage(
//                    model = ImageRequest.Builder(LocalContext.current)
//                        .data(pokemon.sprites?.others?.dreamWorld?.frontDefault)
//                        .decoderFactory(SvgDecoder.Factory()).build(),
//                    contentDescription = "pokemonImage",
//                    Modifier
//                        .width(150.dp)
//                        .height(150.dp),
//                    placeholder = painterResource(id = R.drawable.ic_placeholder),
//                    onSuccess = { result ->
//                        calcDominantColor(result.result.drawable) {
//                            dominantColor = it
//                        }
//                    }
//                )
//            }
//        }
//    }
}

@Composable
fun PokemonDetailTopSection(modifier: Modifier, onBackStackClick: () -> Unit = {}) {
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = modifier
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color.Black,
                        Color.Transparent
                    )
                )
            )
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "backIcon",
            tint = Color.White,
            modifier = modifier
                .size(36.dp)
                .offset(16.dp, 16.dp)
                .clickable {
                    onBackStackClick()
                }
        )
    }
}

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

@Composable
fun PokemonDetailSection(
    pokemon: Pokemon,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .offset(y = 100.dp)
            .verticalScroll(scrollState)
    ) {
        Text(
            text = "#${pokemon.id} ${pokemon.name}",
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface
        )

        PokemonTypeSection(types = pokemon.types)
        PokemonDetailDataSection(pokemonWeight = pokemon.weight, pokemonHeight = pokemon.height)
        PokemonBaseStats(pokemon = pokemon)
    }
}

@Composable
fun PokemonTypeSection(types: List<Types>) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(16.dp)
    ) {
        for (type in types) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .weight(1f)
                    .padding(PaddingValues(horizontal = 8.dp))
                    .clip(CircleShape)
                    .background(parseTypeToColor(type))
                    .height(35.dp)
            ) { Text(
                text = type.type.name,
                color = Color.White,
                fontSize = 18.sp
            )
            }
        }
    }
}

@Composable
fun PokemonDetailDataSection(
    pokemonWeight: Int,
    pokemonHeight: Int,
    sectionHeight: Dp = 80.dp
) {
    val pokemonWeightInKg = remember {
        round(pokemonWeight * 100f) / 100f
    }

    val pokemonHeightInMeters = remember {
        round(pokemonHeight * 100f) / 100f
    }

    Row(
        modifier = Modifier
            .fillMaxSize()
    ) {
        PokemonDetailDataItem(
            dataValue = pokemonWeightInKg,
            dataUnit = "kg" ,
            dataIcon = painterResource(id = R.drawable.ic_weight),
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier
            .size(1.dp, sectionHeight)
            .background(Color.LightGray)
        )

        PokemonDetailDataItem(
            dataValue = pokemonHeightInMeters,
            dataUnit = "m" ,
            dataIcon = painterResource(id = R.drawable.ic_height),
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun PokemonDetailDataItem(
    dataValue: Float,
    dataUnit: String,
    dataIcon: Painter,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Icon(
            painter = dataIcon,
            contentDescription = "weightIcon",
            tint = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "$dataValue$dataUnit",
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun PokemonStat(
    statName: String,
    statValue: Int,
    statMaxValue: Int,
    statColor: Color,
    height: Dp = 28.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0
) {
    var animationPlayed by remember { mutableStateOf(false) }
    val curPercent = animateFloatAsState(
        targetValue = if(animationPlayed) {
            statValue / statMaxValue.toFloat()
        } else 0f,
        animationSpec = tween(
            animDuration,
            animDelay
        )
    )

    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }
    Box(modifier =
    Modifier
        .fillMaxWidth()
        .height(height)
        .clip(CircleShape)
        .background(
            if (isSystemInDarkTheme()) {
                Color(0xFF505050)
            } else {
                Color.LightGray
            }
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(curPercent.value)
                .clip(CircleShape)
                .background(statColor)
                .padding(PaddingValues(horizontal = 8.dp))
        ) {
            Text(
                text = statName,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = (curPercent.value * statMaxValue).toInt().toString(),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun PokemonBaseStats(
    pokemon: Pokemon,
    animDelayPerItem: Int = 100
) {
    val maxBaseStat = remember {
        pokemon.stats.maxBy { it.baseStat }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Base stats:",
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.height(4.dp))

        for(i in pokemon.stats.indices) {
            val stat = pokemon.stats[i]
            PokemonStat(
                statName = parseStatToAbbr(stat),
                statValue = stat.baseStat,
                statMaxValue = maxBaseStat.baseStat,
                animDelay = i * animDelayPerItem,
                statColor = parseStatToColor(stat)
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}