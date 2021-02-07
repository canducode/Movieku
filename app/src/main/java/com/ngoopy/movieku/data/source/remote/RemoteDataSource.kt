package com.ngoopy.movieku.data.source.remote

import androidx.lifecycle.LiveData
import com.ngoopy.movieku.data.Entity.ListMoviesEntity
import com.ngoopy.movieku.data.Entity.ListTVShowsEntity
import com.ngoopy.movieku.data.Entity.MovieEntity
import com.ngoopy.movieku.data.Entity.TVShowEntity
import com.ngoopy.movieku.utils.LiveHelper

class RemoteDataSource private constructor(private val liveHelper: LiveHelper){
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: LiveHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper)
            }
    }

    fun getPopularMovies() : LiveData<List<ListMoviesEntity>> = liveHelper.loadPopularMovies()
    fun getDetailMovie(theId: Int) : LiveData<MovieEntity> = liveHelper.loadDetailMovie(theId)
    fun getPopularTVShows() : LiveData<List<ListTVShowsEntity>> = liveHelper.loadPopularTVShows()
    fun getDetailTVShow(theId: Int) : LiveData<TVShowEntity> = liveHelper.loadDetailTVShow(theId)
}