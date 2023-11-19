package com.example.pokedex.utils

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.ui.graphics.Color
import androidx.palette.graphics.Palette
import com.example.pokedex.models.PokemonCard
import com.example.pokedex.models.PokemonSearch

fun PokemonSearch.getPokemonImage(): List<PokemonCard> {
    val pokedexEntries = this.results.mapIndexed { index, entry ->
        val number = if (entry.url.endsWith("/")) {
            entry.url.dropLast(1).takeLastWhile { it.isDigit() }
        } else {
            entry.url.takeLastWhile { it.isDigit() }
        }
        val url =
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${number}.png"
        PokemonCard(entry.name.replaceFirstChar { it.toString() }, url, number.toInt())
    }
    return pokedexEntries
}

fun calcDominantColor(drawable: Drawable, onFinish: (Color) -> Unit) {
    val bmp = (drawable as BitmapDrawable).bitmap.copy(
        Bitmap.Config.ARGB_8888, true
    )

    Palette.from(bmp).generate { palette ->
        palette?.dominantSwatch?.rgb?.let { colorValue ->
            onFinish(Color(colorValue))
        }
    }
}