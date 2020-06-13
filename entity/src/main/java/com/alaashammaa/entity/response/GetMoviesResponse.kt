package com.alaashammaa.entity.response


import com.alaashammaa.entity.entities.Movie
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetMoviesResponse(
    @Json(name = "page")
    val page: Int,
    @Json(name = "results")
    val movies: List<Movie>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)