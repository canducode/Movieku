package com.ngoopy.movieku.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.ngoopy.movieku.data.source.local.entity.ListMoviesEntity
import com.ngoopy.movieku.data.source.local.entity.ListTVShowsEntity
import com.ngoopy.movieku.data.source.local.entity.MovieEntity
import com.ngoopy.movieku.data.source.local.entity.TVShowEntity

@Dao
interface MoviekuDao {

    // Movies ----------
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPopularMovies(movies: List<ListMoviesEntity>)

    @Query("SELECT * FROM popularmovies")
    fun getPopularMovies(): DataSource.Factory<Int, ListMoviesEntity>

    @Query("UPDATE popularmovies SET bookmarked = :state where id = :movieId")
    fun updatePopularMovies(movieId: Int, state: Boolean)

    @Query("SELECT * FROM popularmovies where bookmarked = 1")
    fun getBookmarkedMovies(): DataSource.Factory<Int, ListMoviesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetailMovie(movie: MovieEntity)

    @Query("SELECT * FROM detailmovie WHERE id = :movieId")
    fun getDetailMovie(movieId: Int): LiveData<MovieEntity>


    // TV Shows ----------
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPopularTVShows(tvshows: List<ListTVShowsEntity>)

    @Query("SELECT * FROM populartvshows")
    fun getPopularTVShows(): DataSource.Factory<Int, ListTVShowsEntity>

    @Query("UPDATE populartvshows SET bookmarked = :state where id = :tvshowId")
    fun updatePopularTVShows(tvshowId: Int, state: Boolean)

    @Query("SELECT * FROM populartvshows WHERE bookmarked = 1")
    fun getBookmarkedTVShows(): DataSource.Factory<Int, ListTVShowsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetailTVShow(tvshow: TVShowEntity)

    @Query("SELECT * FROM detailtvshow WHERE id = :tvshowId")
    fun getDetailTVShow(tvshowId: Int): LiveData<TVShowEntity>

}