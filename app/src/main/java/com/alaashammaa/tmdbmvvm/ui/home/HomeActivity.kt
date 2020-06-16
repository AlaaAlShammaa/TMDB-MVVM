package com.alaashammaa.tmdbmvvm.ui.home

import android.os.Bundle
import androidx.lifecycle.Observer
import com.alaashammaa.app_ui.adapters.MoviesAdapter
import com.alaashammaa.network.Status
import com.alaashammaa.tmdbmvvm.R
import com.alaashammaa.tmdbmvvm.base.DatabindingActivity
import com.alaashammaa.tmdbmvvm.databinding.ActivityHomeBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

@ExperimentalCoroutinesApi
@InternalCoroutinesApi
class HomeActivity : DatabindingActivity() {

    private val homeViewModel: HomeViewModel by viewModel()
    private val binding: ActivityHomeBinding by binding(R.layout.activity_home)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(binding) {
            viewModel = homeViewModel
            lifecycleOwner = this@HomeActivity
            moviesAdapter = MoviesAdapter(ArrayList())
        }
        homeViewModel.movies.observe(this, Observer { response ->
            when (response.status) {
                Status.SUCCESS -> {
                    Timber.d("Got here with data ${response.data}")
                }
                Status.LOADING -> {
                    Timber.d("Got here with loading")
                }
                Status.ERROR -> {
                    Timber.d("Got here with error ${response.message}")
                }
            }
        })

    }
}