package com.alaashammaa.tmdbmvvm.repository

import com.alaashammaa.entity.database.MoviesDao
import com.alaashammaa.entity.entities.Movie
import com.alaashammaa.network.service.MoviesService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

@ExperimentalCoroutinesApi
class MoviesRepository constructor(private val service: MoviesService,private val moviesDao: MoviesDao) {


    suspend fun fetchPopularMovies(): Flow<List<Movie>?> = flow {
        val cachedMovies = moviesDao.getMovies()
        emit(cachedMovies)
        if (cachedMovies.isNullOrEmpty()) {
            val movies: List<Movie>? = service.fetchPopularMovies().movies
            if (cachedMovies.isNullOrEmpty()) {
                moviesDao.insertMovies(movies)
            }
            emit(movies)
        }
    }.flowOn(Dispatchers.IO)

}