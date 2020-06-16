package com.alaashammaa.tmdbmvvm.repository

import com.alaashammaa.entity.entities.Movie
import com.alaashammaa.network.service.MoviesService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

@ExperimentalCoroutinesApi
class MoviesRepository constructor(private val service: MoviesService) {


    suspend fun fetchPopularMovies(): Flow<List<Movie>?> = flow {
        val movies: List<Movie>? = service.fetchPopularMovies().movies
        emit(movies)
    }.flowOn(Dispatchers.IO)

}