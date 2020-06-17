package com.alaashammaa.entity

import com.alaashammaa.entity.entities.Movie

object MockData {
    fun mockMovie() =
        Movie(
            title = "Ad Astra",
            id = 419704,
            releaseDate = "2019-09-17",
            voteAverage = 6.0,
            adult = null,
            backdropPath = null,
            originalLanguage = null,
            originalTitle = null,
            popularity = null,
            posterPath = null,
            video = null,
            voteCount = null,
            overview = null
        )

    fun mockMoviesList() = listOf(mockMovie())
}