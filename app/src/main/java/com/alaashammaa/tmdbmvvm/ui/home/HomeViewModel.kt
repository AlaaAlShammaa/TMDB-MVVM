package com.alaashammaa.tmdbmvvm.ui.home

import androidx.lifecycle.*
import com.alaashammaa.entity.entities.Movie
import com.alaashammaa.network.Resource
import com.alaashammaa.tmdbmvvm.repository.MoviesRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart

@InternalCoroutinesApi
@ExperimentalCoroutinesApi
class HomeViewModel constructor(private val repository: MoviesRepository) : ViewModel() {

    private val _movies = MutableLiveData<Resource<List<Movie>>>()
    val movies: LiveData<Resource<List<Movie>>> get() = _movies

    init {
//        fetchUpcomingMovies()
    }

    fun fetchUpcomingMovies() {
        viewModelScope.launch {
            repository.fetchPopularMovies()
                .onStart { _movies.value = Resource.loading(null) }
                .catch { exception ->
                    // display error message
                    _movies.value = Resource.error(exception.localizedMessage, null)
                }.collect { movies ->
                    _movies.value = Resource.success(movies)
                }
        }
    }
}