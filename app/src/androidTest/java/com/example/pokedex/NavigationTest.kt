package com.example.pokedex

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.pokedex.network.utils.UIState
import com.example.pokedex.screens.PokemonSearchScreen
import com.example.pokedex.utils.pokemonToTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class NavigationTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun pokemonList_isDisplayed_whenSuccess() {
        startPokemonList()
        composeTestRule.onNodeWithContentDescription("pokemonLogo").assertIsDisplayed()
        composeTestRule.onAllNodesWithContentDescription("pokemonImage").assertCountEquals(3)
    }

    @OptIn(ExperimentalMaterial3Api::class)
    private fun startPokemonList() {
        composeTestRule.setContent {
            PokemonSearchScreen(uiState = UIState.Success((pokemonToTest)))
        }
    }

    @Test
    @OptIn(ExperimentalMaterial3Api::class)
    fun pokemonPage_isDisplayed_whenClickOnPokemonCard() {
        composeTestRule.setContent {
            PokemonSearchScreen(uiState = UIState.Success((pokemonToTest)))
        }
        composeTestRule
            .onAllNodesWithContentDescription("pokemonImage")
            .onFirst()
            .performClick()

        composeTestRule.waitUntil(10000) {
            composeTestRule.onAllNodesWithText("pokemonImage")
                .fetchSemanticsNodes().size == 1
        }
    }
}