package com.alaashammaa.network.service

import com.alaashammaa.entity.response.GetMoviesResponse
import com.alaashammaa.network.EndPoint
import retrofit2.http.GET

interface MoviesService {

    @GET(EndPoint.popular)
    fun fetchPopularMovies() : GetMoviesResponse

    @GET(EndPoint.upcoming)
    fun fetchUpcomingMovies() : GetMoviesResponse

    @GET(EndPoint.topRated)
    fun fetchTopRatedMovies() : GetMoviesResponse
}