package com.example.pokedex.remoteprovider

import com.example.pokedex.dto.PokemonSearchDTO
import com.example.pokedex.network.remoteprovider.PokemonSearchRemoteProviderImpl
import com.example.pokedex.network.restclient.PokemonSearchRestClient
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
class PokemonSearchRemoteProviderTest {
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private val pokemonSearchRestClient = mockk<PokemonSearchRestClient>()
    private val limit: Int = 0
    private val offset: Int = 0
    private val remoteProvider = PokemonSearchRemoteProviderImpl(
        pokemonSearchRestClient
    )

    @Before
    fun setup() {
        MockkStaticLog.mockLog()
        MockkStaticRetrofit.mockRetrofit()
    }

    @Test
    fun getPokemonSearch_returnsResponse() = runTest {
        // GIVEN
        val fakeRetrofitResponse: RetrofitResponse<PokemonSearchDTO> = mockk()
        val fakeResponse: Response<PokemonSearchDTO> = mockk()

        coEvery {
            pokemonSearchRestClient.getPokemonList(
                limit = any(),
                offset = any()
            )
        } returns fakeRetrofitResponse

        coEvery { fakeRetrofitResponse.formatResponse() } returns fakeResponse

        //WHEN
        val result = remoteProvider.getPokemonList(limit, offset)

        //THEN
        assertEquals(fakeResponse, result)

        coVerify {
            safeCall<Any>(any())

            pokemonSearchRestClient.getPokemonList(
                limit = limit,
                offset = offset
            )
        }
    }
}