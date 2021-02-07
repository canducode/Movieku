package com.ngoopy.movieku.data.source

import androidx.lifecycle.LiveData
import com.ngoopy.movieku.data.Entity.ListMoviesEntity
import com.ngoopy.movieku.data.Entity.MovieEntity

interface MoviekuDataSource {

    fun getPopularMovies(): LiveData<List<ListMoviesEntity>>
    fun getDetailMovie(theId: Int): LiveData<MovieEntity>
}