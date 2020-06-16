package com.alaashammaa.entity.response


import com.alaashammaa.entity.entities.Movie
import com.google.gson.annotations.SerializedName

data class GetMoviesResponse(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val movies: List<Movie>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)