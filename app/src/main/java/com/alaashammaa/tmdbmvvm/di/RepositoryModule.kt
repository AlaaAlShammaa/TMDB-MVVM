package com.alaashammaa.tmdbmvvm.di

import com.alaashammaa.tmdbmvvm.repository.MoviesRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.dsl.module

@ExperimentalCoroutinesApi
val repositoryModule = module {
    single {
        MoviesRepository(get(),get())
    }
}
