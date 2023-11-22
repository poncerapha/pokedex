package com.example.pokedex.screens

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.pokedex.network.utils.UIState
import com.example.pokedex.utils.samplePokemon
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PokemonPageScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun pokemonPage_isDisplayed_whenSuccess() {
        startPokemonList()
        composeTestRule.onRoot().printToLog("Pokemon Page Screen")
        composeTestRule.onNodeWithContentDescription("backArrowButton").assertIsDisplayed()
        composeTestRule.onNodeWithText("#1 bulbasaur").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("weightIcon").assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription("heightIcon").assertIsDisplayed()
    }

    private fun startPokemonList() {
        composeTestRule.setContent {
            PokemonPageScreen(UIState.Success(samplePokemon))
        }
    }
}