package com.example.pokedex.ui.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.pokedex.utils.pokemonToTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PokemonSearchItemTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun pokemonSearchItem_isDisplayed_whenSuccess() {
        startPokemonList()
        composeTestRule.onNodeWithText("name").assertIsDisplayed()
        composeTestRule.waitUntil(3000) {
            composeTestRule.onAllNodesWithContentDescription("pokemonImage").fetchSemanticsNodes().size == 1
        }
    }

    private fun startPokemonList() {
        composeTestRule.setContent {
            PokemonSearchItem(pokemonToTest.first(), pokemonIndex = 1)
        }
    }
}