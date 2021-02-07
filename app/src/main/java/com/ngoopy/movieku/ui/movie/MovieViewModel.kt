package com.ngoopy.movieku.ui.movie

import androidx.lifecycle.ViewModel
import com.ngoopy.movieku.data.Entity.MovieEntity
import com.ngoopy.movieku.utils.DataDummy

class MovieViewModel : ViewModel() {
    fun getMovies(): List<MovieEntity> = DataDummy.generateDummyMovie()
}