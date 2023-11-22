package com.example.pokedex.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import com.example.pokedex.network.utils.Result
import com.example.pokedex.network.utils.UIState
import com.example.pokedex.network.utils.data
import com.example.pokedex.repository.PokemonPageRepository
import com.example.pokedex.utils.samplePokemon
import com.example.utils.MainCoroutineRule
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class PokemonPageViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var pokemonPageViewModel: PokemonPageViewModel
    private val pokemonPageRepository = mockk<PokemonPageRepository>()
    private val savedStateHandle = mockk<SavedStateHandle>(relaxed = true)

    @Test
    fun fetchPokemon_onSuccess_updateStateFlow() = runTest {
        val fakeResult = samplePokemon

        coEvery {
            savedStateHandle.get<String>("pokemonName")
        } returns "pokemonName"

        coEvery {
            pokemonPageRepository.getPokemon(
                any()
            )
        } returns Result.Success(fakeResult)

        pokemonPageViewModel = PokemonPageViewModel(
            pokemonPageRepository = pokemonPageRepository,
            savedStateHandle = savedStateHandle
        )

        assertEquals(
            UIState.Success::class.java,
            pokemonPageViewModel.uiState.value.javaClass
        )
        assertEquals(fakeResult, pokemonPageViewModel.uiState.value.data)
    }
}