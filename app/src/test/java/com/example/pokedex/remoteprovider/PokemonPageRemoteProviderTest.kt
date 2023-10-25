package com.example.pokedex.remoteprovider

import com.example.pokedex.dto.PokemonDTO
import com.example.pokedex.network.remoteprovider.PokemonPageRemoteProviderImpl
import com.example.pokedex.network.restclient.PokemonPageRestClient
import com.example.utils.MockkStaticLog
import com.example.pokedex.network.utils.Response
import com.example.utils.MainCoroutineRule
import com.example.pokedex.utils.formatResponse
import com.example.pokedex.utils.safeCall
import com.example.utils.MockkStaticRetrofit
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response as RetrofitResponse

@ExperimentalCoroutinesApi
class PokemonPageRemoteProviderTest {
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private val name = "name"
    private val pokemonPageRestClient = mockk<PokemonPageRestClient>()
    private val remoteProvider = PokemonPageRemoteProviderImpl(
        pokemonPageRestClient
    )

    @Before
    fun setup() {
        MockkStaticLog.mockLog()
        MockkStaticRetrofit.mockRetrofit()
    }

    @Test
    fun getPokemon_returnsResponse() = runTest {
        // GIVEN
        val fakeRetrofitResponse: RetrofitResponse<PokemonDTO> = mockk()
        val fakeResponse: Response<PokemonDTO> = mockk()

        coEvery {
            pokemonPageRestClient.getPokemon(
                name = any()
            )
        } returns fakeRetrofitResponse

        coEvery { fakeRetrofitResponse.formatResponse() } returns fakeResponse

        //WHEN
        val result = remoteProvider.getPokemon(name)

        //THEN
        assertEquals(fakeResponse, result)

        coVerify {
            safeCall<Any>(any())

            pokemonPageRestClient.getPokemon(
                name = name
            )
        }
    }
}