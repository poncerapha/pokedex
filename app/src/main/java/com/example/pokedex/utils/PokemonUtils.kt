package com.example.pokedex.utils

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.ui.graphics.Color
import androidx.palette.graphics.Palette
import com.example.pokedex.models.Pokemon
import com.example.pokedex.models.Stat
import com.example.pokedex.models.Stats
import com.example.pokedex.models.Type
import com.example.pokedex.models.Types

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

fun getPokemonUrl(pokemonNumber: Int): String {
    return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/${pokemonNumber}.svg"
}

val samplePokemon = Pokemon(
    name = "bulbasaur",
    height = 69,
    weight = 68,
    id = 1,
    types = listOf(
        Types(
            slot = 1,
            type = Type(
                name = "name",
                url = "url"
            )
        )
    ),
    stats = listOf(
        Stats(
            baseStat = 8,
            effort = 70,
            stat = Stat(
                name = "name",
                url = "url"
            )
        )
    )
)