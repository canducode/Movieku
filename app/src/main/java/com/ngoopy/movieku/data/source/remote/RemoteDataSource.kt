package com.ngoopy.movieku.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ngoopy.movieku.data.source.local.entity.ListMoviesEntity
import com.ngoopy.movieku.data.source.local.entity.ListTVShowsEntity
import com.ngoopy.movieku.data.source.local.entity.MovieEntity
import com.ngoopy.movieku.data.source.local.entity.TVShowEntity
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

    fun getPopularMovies() : LiveData<ApiResponse<List<ListMoviesEntity>>> {
        val resultListMovies = MutableLiveData<ApiResponse<List<ListMoviesEntity>>>()
        liveHelper.loadPopularMovies().observeForever {
            resultListMovies.value = ApiResponse.success(it)
        }
        return resultListMovies
    }

    fun getDetailMovie(movieId: Int) : LiveData<ApiResponse<MovieEntity>> {
        val resultDetailMovie = MutableLiveData<ApiResponse<MovieEntity>>()
        liveHelper.loadDetailMovie(movieId).observeForever {
            resultDetailMovie.value = ApiResponse.success(it)
        }
        return resultDetailMovie
    }

    fun getPopularTVShows() : LiveData<ApiResponse<List<ListTVShowsEntity>>> {
        val resultListTVShows = MutableLiveData<ApiResponse<List<ListTVShowsEntity>>>()
        liveHelper.loadPopularTVShows().observeForever {
            resultListTVShows.value = ApiResponse.success(it)
        }
        return resultListTVShows
    }

    fun getDetailTVShow(tvshowId: Int) : LiveData<ApiResponse<TVShowEntity>> {
        val resultDetailTVShow = MutableLiveData<ApiResponse<TVShowEntity>>()
        liveHelper.loadDetailTVShow(tvshowId).observeForever {
            resultDetailTVShow.value = ApiResponse.success(it)
        }
        return resultDetailTVShow
    }
}