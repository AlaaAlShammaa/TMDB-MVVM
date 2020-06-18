package com.alaashammaa.tmdbmvvm.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.alaashammaa.entity.database.MoviesDao
import com.alaashammaa.entity.entities.Movie
import com.alaashammaa.entity.response.GetMoviesResponse
import com.alaashammaa.network.service.MoviesService
import com.alaashammaa.tmdbmvvm.MainCoroutinesRule
import com.alaashammaa.tmdbmvvm.MockData
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@ExperimentalCoroutinesApi
class MoviesRepositoryTest {
    private lateinit var repository: MoviesRepository
    private val service: MoviesService = mock()
    private val moviesDao: MoviesDao = mock()

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesRule = MainCoroutinesRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        repository = MoviesRepository(service, moviesDao)
    }

    @Test
    fun fetchPopularMoviesTest() = runBlocking {
        val mockData = MockData.mockMoviesList()
        whenever(moviesDao.getMovies()).thenReturn(emptyList())
        whenever(service.fetchPopularMovies()).thenReturn(
            GetMoviesResponse(
                movies = mockData,
                page = 1,
                totalPages = 1,
                totalResults = 1
            )
        )

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