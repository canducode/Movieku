package com.ngoopy.movieku.data.source

import androidx.lifecycle.LiveData
import com.ngoopy.movieku.data.Entity.ListMoviesEntity
import com.ngoopy.movieku.data.Entity.ListTVShowsEntity
import com.ngoopy.movieku.data.Entity.MovieEntity
import com.ngoopy.movieku.data.Entity.TVShowEntity

interface MoviekuDataSource {
    fun getPopularMovies(): LiveData<List<ListMoviesEntity>>
    fun getDetailMovie(theId: Int): LiveData<MovieEntity>
    fun getPopularTVShows(): LiveData<List<ListTVShowsEntity>>
    fun getDetailTVShow(theId: Int): LiveData<TVShowEntity>
}