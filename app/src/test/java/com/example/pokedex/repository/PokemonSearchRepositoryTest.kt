package com.example.pokedex.repository

import com.example.utils.MainCoroutineRule
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.pokedex.dto.PokemonSearchDTO
import com.example.pokedex.models.PokemonSearch
import com.example.pokedex.network.utils.Response
import com.example.pokedex.network.utils.Result
import com.example.pokedex.network.utils.Result.*
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class PokemonSearchRepositoryTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private var offset: Int = 0
    private var limit: Int = 10
    private val pokemonSearchRemoteProvider = mockk<PokemonSearchRemoteProvider>()
    private lateinit var pokemonSearchRepository: PokemonSearchRepository

    @Before
    fun setup() {
        pokemonSearchRepository = PokemonSearchRepositoryImpl(
            pokemonSearchRemoteProvider = pokemonSearchRemoteProvider
        )
    }

    @Test
    fun getPokemonSearchList_onSuccess_returnResultSuccess() = runTest {
        val fakePokemonSearch: PokemonSearch = mockk()
        val fakeRetrofitResponse: Response.Success<PokemonSearchDTO> = mockk {
            every { toResult<PokemonSearch>(any()) } returns Success(fakePokemonSearch)
        }

        coEvery { pokemonSearchRemoteProvider.getPokemonList(
            any(),
            any()
        ) } returns fakeRetrofitResponse

        val result = pokemonSearchRepository.getPokemonList(limit, offset)

        Assert.assertEquals(fakePokemonSearch, (result as Result.Success).data)

        coVerify {
            pokemonSearchRemoteProvider.getPokemonList(
                limit = limit,
                offset = offset
            )
        }
    }
}