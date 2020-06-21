package com.alaashammaa.tmdbmvvm.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.alaashammaa.entity.database.MoviesDao
import com.alaashammaa.entity.entities.Movie
import com.alaashammaa.entity.response.GetMoviesResponse
import com.alaashammaa.network.service.MoviesService
import com.alaashammaa.tmdbmvvm.MainCoroutinesRule
import com.alaashammaa.tmdbmvvm.MockData
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


@ExperimentalCoroutinesApi
class MoviesRepositoryTest {
    private lateinit var repository: MoviesRepository

    @Mock
    private lateinit var service: MoviesService

    @Mock
    private lateinit var moviesDao: MoviesDao

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesRule = MainCoroutinesRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        repository = MoviesRepository(service, moviesDao)
    }

    @Test
    fun fetchPopularMoviesTest() = runBlocking {
        val mockData = MockData.mockMoviesList()
        val moviesResponse = GetMoviesResponse(
            movies = mockData,
            page = 1,
            totalPages = 1,
            totalResults = 1
        )

        Mockito.doReturn(emptyList<Movie>())
            .`when`(moviesDao)
            .getMovies()
        Mockito.doReturn(moviesResponse)
            .`when`(service)
            .fetchPopularMovies()

        val movies: Flow<List<Movie>?> = repository.fetchPopularMovies()


        movies.collectIndexed { index, value ->
            // check that the value that we got from db is empty
            if (index == 0) assert(value.isNullOrEmpty())

            // check the second value that we get from db is equal to the value that we got from mockedData
            if (index == 1) {
                value?.get(0)?.equals(mockData[0])?.let { assert(it) }//
            }

        }
    }

}