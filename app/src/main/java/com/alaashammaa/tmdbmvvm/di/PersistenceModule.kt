package com.alaashammaa.tmdbmvvm.di

import androidx.room.Room
import com.alaashammaa.entity.database.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import com.alaashammaa.tmdbmvvm.R

val persistenceModule = module {

    single {
        Room.databaseBuilder(
            androidApplication(), AppDatabase::class.java,
            androidApplication().getString(R.string.database)
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<AppDatabase>().moviesDao() }

}
