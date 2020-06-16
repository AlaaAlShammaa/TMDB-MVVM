package com.alaashammaa.entity.database

import androidx.room.*
import com.alaashammaa.entity.entities.Movie

@Dao
interface MoviesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<Movie>?)

    @Update
    suspend fun updateMovie(movie: Movie)

    @Query("SELECT * FROM Movie")
    suspend fun getMovies(): List<Movie>

    @Query("DELETE FROM Movie WHERE id=:movieId")
    suspend fun clearMovies(movieId: Int)
}