package com.example.pokedex.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.pokedex.dto.PokemonDTO
import com.example.pokedex.dto.PokemonSearchDTO
import com.example.pokedex.models.Pokemon
import com.example.pokedex.models.PokemonSearch
import com.example.pokedex.network.remoteprovider.PokemonPageRemoteProvider
import com.example.pokedex.network.remoteprovider.PokemonSearchRemoteProvider
import com.example.pokedex.network.utils.Response
import com.example.pokedex.network.utils.Result
import com.example.pokedex.utils.MainCoroutineRule
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
class PokemonPageRepositoryTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private val name = "name"
    private val pokemonPageRemoteProvider = mockk<PokemonPageRemoteProvider>()
    private lateinit var pokemonPageRepository: PokemonPageRepository

    @Before
    fun setup() {
        pokemonPageRepository = PokemonPageRepositoryImpl(
            pokemonPageRemoteProvider = pokemonPageRemoteProvider
        )
    }

    @Test
    fun getPokemon_onSuccess_returnResultSuccess() = runTest {
        val fakePokemon: Pokemon = mockk()
        val fakeRetrofitResponse: Response.Success<PokemonDTO> = mockk {
            every { toResult<Pokemon>(any()) } returns Result.Success(fakePokemon)
        }

        coEvery { pokemonPageRemoteProvider.getPokemon(
            any()
        ) } returns fakeRetrofitResponse

        val result = pokemonPageRepository.getPokemon(name)

        Assert.assertEquals(fakePokemon, (result as Result.Success).data)

        coVerify {
            pokemonPageRemoteProvider.getPokemon(
                name = name
            )
        }
    }
}