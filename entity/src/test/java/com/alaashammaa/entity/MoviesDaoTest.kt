package com.alaashammaa.entity

import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import kotlin.test.assertEquals

@RunWith(RobolectricTestRunner::class)
class MoviesDaoTest : LocalDatabase() {
    @Test
    fun insertAndReadTest() = runBlocking {
        val mockData = MockData.mockMoviesList()
        db.moviesDao().insertMovies(mockData)
        val loadFromDB = db.moviesDao().getMovies()[0]
        assertEquals(loadFromDB.id, mockData[0].id)
        assertEquals(loadFromDB.title, mockData[0].title)
        assertEquals(loadFromDB.voteAverage, mockData[0].voteAverage)
    }

    @Test
    fun updateAndReadTest()= runBlocking {
        // insert movie into db
        val mockData = MockData.mockMoviesList()
        db.moviesDao().insertMovies(mockData)
        val loadFromDB = db.moviesDao().getMovies()[0]
        assertEquals(loadFromDB.voteAverage, 6.0)
        
        // update movie vote average
        loadFromDB.voteAverage = 7.0
        db.moviesDao().updateMovie(loadFromDB)

        // load movie from db and assert update
        val updatedLoadFromDb = db.moviesDao().getMovies()[0]
        assertEquals(updatedLoadFromDb.voteAverage, 7.0)
    }
}