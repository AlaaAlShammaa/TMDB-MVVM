package com.alaashammaa.tmdbmvvm.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.alaashammaa.entity.entities.Movie
import com.alaashammaa.network.Resource
import com.alaashammaa.tmdbmvvm.MockData
import com.alaashammaa.tmdbmvvm.TestCoroutineRule
import com.alaashammaa.tmdbmvvm.repository.MoviesRepository
import com.alaashammaa.tmdbmvvm.ui.home.HomeViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@InternalCoroutinesApi
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var moviesRepository: MoviesRepository

    @Mock
    private lateinit var observer: Observer<Resource<List<Movie>>>


    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun fetchUpcomingMoviesTestSuccess() {

        val mockData = MockData.mockMoviesList()

        val mockedFlow: Flow<List<Movie>?> = flow {
            delay(500)
            emit(mockData)
        }

        testCoroutineRule.runBlockingTest {
            doReturn(mockedFlow)
                .`when`(moviesRepository)
                .fetchPopularMovies()

            val homeViewModel = HomeViewModel(moviesRepository)

            homeViewModel.movies.observeForever(observer)
            homeViewModel.fetchUpcomingMovies()

            verify(observer).onChanged(Resource.loading(null))
            this.advanceTimeBy(500)
            verify(observer).onChanged(Resource.success(mockData))
        }

    }

    @Test
    fun fetchUpcomingMoviesTestFailureWithException() {

        val mockedFlow: Flow<List<Movie>?> = flow {
            delay(500)
            throw NullPointerException()
        }

        testCoroutineRule.runBlockingTest {
            doReturn(mockedFlow)
                .`when`(moviesRepository)
                .fetchPopularMovies()

            val homeViewModel = HomeViewModel(moviesRepository)

            homeViewModel.movies.observeForever(observer)
            homeViewModel.fetchUpcomingMovies()

            verify(observer).onChanged(Resource.loading(null))
            this.advanceTimeBy(500)
            verify(observer).onChanged(Resource.error(null, null))
        }

    }
}