package com.ngoopy.movieku.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.ngoopy.movieku.data.source.local.entity.ListMoviesEntity
import com.ngoopy.movieku.data.source.local.entity.ListTVShowsEntity
import com.ngoopy.movieku.data.source.local.entity.MovieEntity
import com.ngoopy.movieku.data.source.local.entity.TVShowEntity
import com.ngoopy.movieku.vo.Resource

interface MoviekuDataSource {
    fun getPopularMovies(): LiveData<Resource<PagedList<ListMoviesEntity>>>
    fun getDetailMovie(movieId: Int): LiveData<Resource<MovieEntity>>
    fun getBookmarkedMovies(): LiveData<PagedList<ListMoviesEntity>>
    fun setMovieBookmark(movieId: Int, state: Boolean)

    fun getPopularTVShows(): LiveData<Resource<PagedList<ListTVShowsEntity>>>
    fun getDetailTVShow(tvshowId: Int): LiveData<Resource<TVShowEntity>>
    fun getBookmarkedTVShows(): LiveData<PagedList<ListTVShowsEntity>>
    fun setTVShowBookmark(tvshowId: Int, state: Boolean)
}