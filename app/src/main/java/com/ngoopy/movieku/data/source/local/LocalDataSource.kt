package com.ngoopy.movieku.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.ngoopy.movieku.data.source.local.entity.ListMoviesEntity
import com.ngoopy.movieku.data.source.local.entity.ListTVShowsEntity
import com.ngoopy.movieku.data.source.local.entity.MovieEntity
import com.ngoopy.movieku.data.source.local.entity.TVShowEntity
import com.ngoopy.movieku.data.source.local.room.MoviekuDao

class LocalDataSource private constructor(private val mMoviekuDao: MoviekuDao) {
    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(moviekuDao: MoviekuDao): LocalDataSource {
            if (INSTANCE == null) {
                INSTANCE = LocalDataSource(moviekuDao)
            }
            return INSTANCE as LocalDataSource
        }
    }

    // Movies ----------
    fun insertPopularMovies(movies: List<ListMoviesEntity>) = mMoviekuDao.insertPopularMovies(movies)
    fun getPopularMovies(): DataSource.Factory<Int, ListMoviesEntity> = mMoviekuDao.getPopularMovies()
    fun getBookmarkedMovies(): DataSource.Factory<Int, ListMoviesEntity> = mMoviekuDao.getBookmarkedMovies()
    fun insertDetailMovie(movie: MovieEntity) = mMoviekuDao.insertDetailMovie(movie)
    fun getDetailMovie(movieId: Int): LiveData<MovieEntity> = mMoviekuDao.getDetailMovie(movieId)
    fun setMovieBookmark(movieId: Int, newState: Boolean) {
        mMoviekuDao.updatePopularMovies(movieId, newState)
    }

    // TV Shows ----------
    fun insertPopularTVShows(tvshows: List<ListTVShowsEntity>) = mMoviekuDao.insertPopularTVShows(tvshows)
    fun getPopularTVShows(): DataSource.Factory<Int, ListTVShowsEntity> = mMoviekuDao.getPopularTVShows()
    fun getBookmarkedTVShows(): DataSource.Factory<Int, ListTVShowsEntity> = mMoviekuDao.getBookmarkedTVShows()
    fun insertDetailTVShow(tvshow: TVShowEntity) = mMoviekuDao.insertDetailTVShow(tvshow)
    fun getDetailTVShow(tvshowId: Int): LiveData<TVShowEntity> = mMoviekuDao.getDetailTVShow(tvshowId)
    fun setTVShowsBookmark(tvshowId: Int, newState: Boolean) {
        mMoviekuDao.updatePopularTVShows(tvshowId, newState)
    }
}