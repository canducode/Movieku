package com.ngoopy.movieku.data.source

import androidx.lifecycle.LiveData
import com.ngoopy.movieku.data.MoviekuDataSource
import com.ngoopy.movieku.data.source.local.entity.ListMoviesEntity
import com.ngoopy.movieku.data.source.local.entity.ListTVShowsEntity
import com.ngoopy.movieku.data.source.local.entity.MovieEntity
import com.ngoopy.movieku.data.source.local.entity.TVShowEntity
import com.ngoopy.movieku.data.source.remote.RemoteDataSource

class FakeMoviekuRepository(private val remoteDataSource: RemoteDataSource) : MoviekuDataSource {

    override fun getPopularMovies(): LiveData<List<ListMoviesEntity>> = remoteDataSource.getPopularMovies()
    override fun getDetailMovie(theId: Int): LiveData<MovieEntity> = remoteDataSource.getDetailMovie(theId)
    override fun getPopularTVShows(): LiveData<List<ListTVShowsEntity>> = remoteDataSource.getPopularTVShows()
    override fun getDetailTVShow(theId: Int): LiveData<TVShowEntity> = remoteDataSource.getDetailTVShow(theId)
}