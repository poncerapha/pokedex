package com.example.pokedex

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class NavigationTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun pokemonList_isDisplayed_whenSuccess() {
//        startPokemonList()
        composeTestRule.onNodeWithContentDescription("pokemonLogo").assertIsDisplayed()
        composeTestRule.onAllNodesWithContentDescription("pokemonImage").assertCountEquals(3)
    }

    @OptIn(ExperimentalMaterial3Api::class)
    private fun startPokemonList() {
        composeTestRule.setContent {
//            PokemonSearchScreen()
        }
    }
}