package com.ngoopy.movieku.data

import androidx.lifecycle.LiveData
import com.ngoopy.movieku.data.source.local.entity.ListMoviesEntity
import com.ngoopy.movieku.data.source.local.entity.ListTVShowsEntity
import com.ngoopy.movieku.data.source.local.entity.MovieEntity
import com.ngoopy.movieku.data.source.local.entity.TVShowEntity

interface MoviekuDataSource {
    fun getPopularMovies(): LiveData<List<ListMoviesEntity>>
    fun getDetailMovie(theId: Int): LiveData<MovieEntity>
    fun getPopularTVShows(): LiveData<List<ListTVShowsEntity>>
    fun getDetailTVShow(theId: Int): LiveData<TVShowEntity>
}