//package com.example.pokedex.viewmodel
//
//import androidx.arch.core.executor.testing.InstantTaskExecutorRule
//import com.example.pokedex.models.Pokemon
//import com.example.pokedex.network.utils.Result
//import com.example.pokedex.network.utils.UIState
//import com.example.pokedex.network.utils.data
//import com.example.pokedex.repository.PokemonPageRepository
//import com.example.utils.MainCoroutineRule
//import io.mockk.coEvery
//import io.mockk.mockk
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.test.runTest
//import org.junit.Assert.assertEquals
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
//
//@ExperimentalCoroutinesApi
//class PokemonPageViewModelTest {
//
//    @get:Rule
//    var instantExecutorRule = InstantTaskExecutorRule()
//
//    @ExperimentalCoroutinesApi
//    @get:Rule
//    var mainCoroutineRule = MainCoroutineRule()
//
//    private val name = "name"
//    private lateinit var pokemonPageViewModel: PokemonPageViewModel
//    private val pokemonPageRepository = mockk<PokemonPageRepository>()
//
//    @Before
//    fun setup() {
//        pokemonPageViewModel = PokemonPageViewModel(
//            pokemonPageRepository = pokemonPageRepository
//        )
//    }
//
//    @Test
//    fun fetchPokemon_onSuccess_updateLiveData() = runTest {
//        val fakeResult = Pokemon(
//            name = name,
//            sprites = mockk()
//        )
//
//        coEvery {
//            pokemonPageRepository.getPokemon(
//                any()
//            )
//        } returns Result.Success(fakeResult)
//
//        pokemonPageViewModel.getPokemon(name)
//
//        assertEquals(
//            UIState.Success::class.java,
//            pokemonPageViewModel.pokemon.value?.javaClass
//        )
//        assertEquals(fakeResult, pokemonPageViewModel.pokemon.value?.data)
//    }
//}