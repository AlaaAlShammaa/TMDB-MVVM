package com.alaashammaa.app_ui.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alaashammaa.app_ui.adapters.MoviesAdapter
import com.alaashammaa.entity.entities.Movie
import com.alaashammaa.app_ui.databinding.ItemMovieBinding

class MoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding: ItemMovieBinding by bindings(view)

    private lateinit var data: Movie

    fun bindData(
        data: Movie,
        movieClickListener: MoviesAdapter.MovieClickListener
    ) {
        this.data = data
        drawItemUI(movieClickListener)
    }

    private fun drawItemUI(movieClickListener: MoviesAdapter.MovieClickListener) {
        binding.apply {
            movie = data
            constraintLayout.setOnClickListener {
                movieClickListener.onMovieClick(data)
            }
            executePendingBindings()
        }
    }


}