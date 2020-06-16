package com.alaashammaa.network.service

import com.alaashammaa.entity.response.GetMoviesResponse
import com.alaashammaa.network.ApiResponse
import com.alaashammaa.network.EndPoint
import retrofit2.http.GET

interface MoviesService {

    @GET(EndPoint.popular)
    suspend fun fetchPopularMovies(): GetMoviesResponse

    @GET(EndPoint.upcoming)
    suspend fun fetchUpcomingMovies(): GetMoviesResponse

    @GET(EndPoint.topRated)
    suspend fun fetchTopRatedMovies(): GetMoviesResponse
}