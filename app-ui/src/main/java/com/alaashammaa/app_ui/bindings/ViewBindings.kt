package com.alaashammaa.app_ui.bindings

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alaashammaa.app_ui.adapters.MoviesAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadImage")
fun bindMoviesAdapter(view: ImageView, path: String?) {
    Glide.with(view.context).load("https://image.tmdb.org/t/p/w500" + path).into(view)
}