package com.alaashammaa.tmdbmvvm.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import com.alaashammaa.entity.entities.Movie
import com.alaashammaa.tmdbmvvm.R
import com.alaashammaa.tmdbmvvm.base.DatabindingActivity
import com.alaashammaa.tmdbmvvm.databinding.ActivityDetailsBinding

class DetailsActivity : DatabindingActivity() {

    private val binding: ActivityDetailsBinding by binding(R.layout.activity_details)

    companion object {
        const val EXTRA_KEY_MOVIE = "EXTRA_KEY_MOVIE"

        fun getStartIntent(context: Context, movie: Movie): Intent {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra(EXTRA_KEY_MOVIE, movie)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val movie: Movie? = intent?.getParcelableExtra("EXTRA_KEY_MOVIE") as Movie?
        binding.apply {
            binding.movie = movie
            binding.coordinator.transitionName = movie?.id.toString()
            lifecycleOwner = this@DetailsActivity
        }
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> {
                true
            }
        }
    }
}