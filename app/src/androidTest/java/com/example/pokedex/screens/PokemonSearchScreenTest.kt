package com.example.pokedex.screens

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.pokedex.utils.pokemonToTest
import kotlinx.coroutines.flow.flowOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class PokemonSearchScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun pokemonList_isDisplayed_whenSuccess() {
        startPokemonList()
        composeTestRule.onNodeWithContentDescription("pokemonLogo").assertIsDisplayed()
        composeTestRule.waitUntil(3000) {
            composeTestRule.onAllNodesWithContentDescription("pokemonImage")
                .fetchSemanticsNodes().size == 3
        }
    }

    private fun startPokemonList() {
        composeTestRule.setContent {
            val pokemons = flowOf(PagingData.from(pokemonToTest)).collectAsLazyPagingItems()
            PokemonSearchScreen(pokemons)
        }
    }
}