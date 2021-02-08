package com.ngoopy.movieku.data.source

import androidx.lifecycle.LiveData
import com.ngoopy.movieku.data.entity.ListMoviesEntity
import com.ngoopy.movieku.data.entity.ListTVShowsEntity
import com.ngoopy.movieku.data.entity.MovieEntity
import com.ngoopy.movieku.data.entity.TVShowEntity
import com.ngoopy.movieku.data.source.remote.RemoteDataSource

class FakeMoviekuRepository(private val remoteDataSource: RemoteDataSource) : MoviekuDataSource {

    override fun getPopularMovies(): LiveData<List<ListMoviesEntity>> = remoteDataSource.getPopularMovies()
    override fun getDetailMovie(theId: Int): LiveData<MovieEntity> = remoteDataSource.getDetailMovie(theId)
    override fun getPopularTVShows(): LiveData<List<ListTVShowsEntity>> = remoteDataSource.getPopularTVShows()
    override fun getDetailTVShow(theId: Int): LiveData<TVShowEntity> = remoteDataSource.getDetailTVShow(theId)
}