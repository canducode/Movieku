package com.ngoopy.movieku.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ngoopy.movieku.data.source.local.entity.ListMoviesEntity
import com.ngoopy.movieku.data.MoviekuRepository

class MovieViewModel(private val moviekuRepository: MoviekuRepository) : ViewModel() {
    fun getPopularMovies(): LiveData<List<ListMoviesEntity>> = moviekuRepository.getPopularMovies()
}