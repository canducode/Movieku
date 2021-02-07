package com.ngoopy.movieku.data.source

import androidx.lifecycle.LiveData
import com.ngoopy.movieku.data.Entity.ListMoviesEntity

interface MoviekuDataSource {

    fun getPopularMovies(): LiveData<List<ListMoviesEntity>>
}