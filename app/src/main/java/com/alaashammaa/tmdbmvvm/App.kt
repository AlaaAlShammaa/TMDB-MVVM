package com.alaashammaa.tmdbmvvm

import android.app.Application
import com.alaashammaa.tmdbmvvm.di.networkModule
import com.alaashammaa.tmdbmvvm.di.persistenceModule
import com.alaashammaa.tmdbmvvm.di.repositoryModule
import com.alaashammaa.tmdbmvvm.di.viewModelModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

@ExperimentalCoroutinesApi
@InternalCoroutinesApi
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(networkModule)
            modules(persistenceModule)
            modules(repositoryModule)
            modules(viewModelModule)
        }

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}