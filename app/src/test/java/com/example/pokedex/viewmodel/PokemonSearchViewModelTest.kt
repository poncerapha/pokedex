package com.example.pokedex.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.pokedex.models.PokemonCard
import com.example.pokedex.models.PokemonSearch
import com.example.pokedex.network.utils.Result
import com.example.pokedex.network.utils.UIPagingState
import com.example.pokedex.network.utils.data
import com.example.pokedex.repository.PokemonSearchRepository
import com.example.pokedex.repository.PokemonSearchRepositoryTest
import com.example.pokedex.utils.MainCoroutineRule
import com.example.pokedex.utils.getPokemonImage
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class PokemonSearchViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var pokemonSearchViewModel: PokemonSearchViewModel
    private val pokemonSearchRepository = mockk<PokemonSearchRepository>()

    @Before
    fun setup() {
        pokemonSearchViewModel = PokemonSearchViewModel(
            pokemonSearchRepository = pokemonSearchRepository
        )
    }

    @Test
    fun fetchPokemonList_onSuccess_updateLiveData() = runTest {
        val fakePokemonCard = mockk<PokemonCard>()
        val fakeResult = PokemonSearch(
            results = listOf(mockk()),
            count = 0,
            next = "next"
        )

        coEvery { fakeResult.getPokemonImage() } returns listOf(fakePokemonCard)

        coEvery {
            pokemonSearchRepository.getPokemonList(
                any(), any()
            )
        } returns Result.Success(fakeResult)

        pokemonSearchViewModel.getPokemonSearchList()

        assertEquals(
            UIPagingState.Success::class.java,
            pokemonSearchViewModel.pokemonSearchList.value?.javaClass
        )
        assertEquals(fakeResult.results, pokemonSearchViewModel.pokemonSearchList.value?.data)
    }
}