package com.alaashammaa.network

import com.alaashammaa.entity.entities.Movie
import com.alaashammaa.network.service.MoviesService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class MoviesServiceTest: ApiAbstract<MoviesService>() {
    private lateinit var service: MoviesService

    @Before
    fun initService() {
        service = createService(MoviesService::class.java)
    }

    @Test
    fun fetchPopularMoviesTest() = runBlocking {
        enqueueResponse("/MoviesResponse.json")
        val responseBody: List<Movie> = requireNotNull(service.fetchPopularMovies().movies)
        mockWebServer.takeRequest()
        assertEquals(responseBody[0].id, 419704, "Failed to match movie id")
        assertEquals(responseBody.size, 20, "Missing data in response")
    }


}