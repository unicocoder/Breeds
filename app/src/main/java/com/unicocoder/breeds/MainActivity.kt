package com.unicocoder.breeds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import coil.load
import coil.transform.RoundedCornersTransformation
import com.unicocoder.breeds.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel by viewModels<MainViewModel>()
    private lateinit var _binding: ActivityMainBinding

    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        fetchData()
    }

    private fun fetchData() {
        mainViewModel.fetchDogResponse()
        mainViewModel.response.observe(this) { response ->
            when (response) {
                is NetworkResult.Success -> {
                    _binding.imageView.load(
                        response.data?.message
                    ) {
                        transformations(RoundedCornersTransformation(16f))
                    }
                    // bind data to the view
                }
                is NetworkResult.Error -> {
                    // show error message
                }
                is NetworkResult.Loading -> {
                    // show a progress bar
                }
            }
        }
    }
}