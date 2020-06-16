package com.alaashammaa.tmdbmvvm.di

import com.alaashammaa.tmdbmvvm.ui.home.HomeViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@ExperimentalCoroutinesApi
@InternalCoroutinesApi
val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
}
