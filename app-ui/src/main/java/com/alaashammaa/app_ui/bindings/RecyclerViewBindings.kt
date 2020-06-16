package com.alaashammaa.app_ui.bindings

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alaashammaa.app_ui.adapters.MoviesAdapter
import com.alaashammaa.entity.entities.Movie

@BindingAdapter("bindMoviesAdapter")
fun bindMoviesAdapter(view: RecyclerView, adapter: MoviesAdapter) {
    view.adapter = adapter
}

@BindingAdapter("bindMoviesList")
fun bindMoviesList(view: RecyclerView, items: List<Movie>?) {
    items?.let {
        (view.adapter as MoviesAdapter).addMovieItems(items)
    }
}

