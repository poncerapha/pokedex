package com.example.pokedex

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.pokedex.network.utils.UIState
import com.example.pokedex.screens.PokemonSearchScreen
import com.example.pokedex.utils.pokemonToTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PokemonSearchTest {
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
}