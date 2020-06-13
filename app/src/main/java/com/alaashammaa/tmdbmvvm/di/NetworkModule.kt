package com.alaashammaa.tmdbmvvm.di

import com.alaashammaa.network.EndPoint
import com.alaashammaa.network.RequestInterceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
  single {
    OkHttpClient.Builder()
      .addInterceptor(RequestInterceptor())
      .build()
  }

  single {
    Retrofit.Builder()
      .client(get<OkHttpClient>())
      .baseUrl(EndPoint.theMovieDB)
      .addConverterFactory(MoshiConverterFactory.create())
      .build()
  }

}
