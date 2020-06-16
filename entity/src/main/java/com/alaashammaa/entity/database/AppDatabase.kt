package com.alaashammaa.entity.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alaashammaa.entity.entities.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao
}