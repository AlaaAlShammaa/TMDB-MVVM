package com.alaashammaa.app_ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alaashammaa.app_ui.R
import com.alaashammaa.app_ui.viewholders.MoviesViewHolder
import com.alaashammaa.entity.entities.Movie

class MoviesAdapter(private val items: ArrayList<Movie>) : RecyclerView.Adapter<MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder =
        MoviesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bindData(items[position])
    }

    fun addMovieItems(movieItems: List<Movie>) {
        items.clear()
        items.addAll(movieItems)
        notifyDataSetChanged()
    }

}