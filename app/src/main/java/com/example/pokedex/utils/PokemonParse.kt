package com.example.pokedex.utils

import androidx.compose.ui.graphics.Color
import com.example.pokedex.models.Stats
import com.example.pokedex.models.Types
import com.example.pokedex.ui.theme.AtkColor
import com.example.pokedex.ui.theme.DefColor
import com.example.pokedex.ui.theme.HPColor
import com.example.pokedex.ui.theme.SpAtkColor
import com.example.pokedex.ui.theme.SpDefColor
import com.example.pokedex.ui.theme.SpdColor
import com.example.pokedex.ui.theme.TypeBug
import com.example.pokedex.ui.theme.TypeDark
import com.example.pokedex.ui.theme.TypeDragon
import com.example.pokedex.ui.theme.TypeElectric
import com.example.pokedex.ui.theme.TypeFairy
import com.example.pokedex.ui.theme.TypeFighting
import com.example.pokedex.ui.theme.TypeFire
import com.example.pokedex.ui.theme.TypeFlying
import com.example.pokedex.ui.theme.TypeGhost
import com.example.pokedex.ui.theme.TypeGrass
import com.example.pokedex.ui.theme.TypeGround
import com.example.pokedex.ui.theme.TypeIce
import com.example.pokedex.ui.theme.TypeNormal
import com.example.pokedex.ui.theme.TypePoison
import com.example.pokedex.ui.theme.TypePsychic
import com.example.pokedex.ui.theme.TypeRock
import com.example.pokedex.ui.theme.TypeSteel
import com.example.pokedex.ui.theme.TypeWater
import java.util.Locale

fun parseTypeToColor(type: Types): Color {
    return when(type.type.name.lowercase(Locale.ROOT)) {
        "normal" -> TypeNormal
        "fire" -> TypeFire
        "water" -> TypeWater
        "electric" -> TypeElectric
        "grass" -> TypeGrass
        "ice" -> TypeIce
        "fighting" -> TypeFighting
        "poison" -> TypePoison
        "ground" -> TypeGround
        "flying" -> TypeFlying
        "psychic" -> TypePsychic
        "bug" -> TypeBug
        "rock" -> TypeRock
        "ghost" -> TypeGhost
        "dragon" -> TypeDragon
        "dark" -> TypeDark
        "steel" -> TypeSteel
        "fairy" -> TypeFairy
        else -> Color.Black
    }
}

fun parseStatToColor(stat: Stats): Color {
    return when(stat.stat.name.lowercase(Locale.ROOT)) {
        "hp" -> HPColor
        "attack" -> AtkColor
        "defense" -> DefColor
        "special-attack" -> SpAtkColor
        "special-defense" -> SpDefColor
        "speed" -> SpdColor
        else -> Color.White
    }
}

fun parseStatToAbbr(stat: Stats): String {
    return when(stat.stat.name.lowercase(Locale.ROOT)) {
        "hp" -> "HP"
        "attack" -> "Atk"
        "defense" -> "Def"
        "special-attack" -> "SpAtk"
        "special-defense" -> "SpDef"
        "speed" -> "Spd"
        else -> ""
    }
}