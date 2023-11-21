package com.example.pokedex.mappers

import com.example.pokedex.dto.StatsDTO
import com.example.pokedex.models.Stats

fun StatsDTO.toStatsModel() = Stats(
    baseStat = baseStat,
    effort = effort,
    stat = stat.toStatModel()
)