package com.example.pokedex.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.pokedex.R

internal const val splashScreenRoute = "splashScreen"

fun NavGraphBuilder.splashScreen(
    onNavigateToPokemonSearch: () -> Unit = {}
) {
    composable(
        route = splashScreenRoute
    ) {
        SplashScreen(
            onAnimationFinished = onNavigateToPokemonSearch
        )
    }
}

@Composable
fun SplashScreen(
    onAnimationFinished: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.logo))
            val logoAnimationState = animateLottieCompositionAsState(composition = composition)
            LottieAnimation(composition = composition, progress = { logoAnimationState.progress })
            if (logoAnimationState.isAtEnd && logoAnimationState.isPlaying) {
                onAnimationFinished()
            }
        }
    }
}