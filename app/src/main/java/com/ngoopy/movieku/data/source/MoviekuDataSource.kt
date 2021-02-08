package com.ngoopy.movieku.data.source

import androidx.lifecycle.LiveData
import com.ngoopy.movieku.data.entity.ListMoviesEntity
import com.ngoopy.movieku.data.entity.ListTVShowsEntity
import com.ngoopy.movieku.data.entity.MovieEntity
import com.ngoopy.movieku.data.entity.TVShowEntity

interface MoviekuDataSource {
    fun getPopularMovies(): LiveData<List<ListMoviesEntity>>
    fun getDetailMovie(theId: Int): LiveData<MovieEntity>
    fun getPopularTVShows(): LiveData<List<ListTVShowsEntity>>
    fun getDetailTVShow(theId: Int): LiveData<TVShowEntity>
}