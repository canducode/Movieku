package com.ngoopy.movieku.utils

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ngoopy.movieku.data.Entity.ListMoviesEntity
import com.ngoopy.movieku.data.Entity.MovieEntity
import com.ngoopy.movieku.data.source.remote.response.DetailMovieResponse
import com.ngoopy.movieku.data.source.remote.response.ListPopularMoviesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LiveHelper {
    companion object {
        private val TAG = LiveHelper::class.java.simpleName
        private const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500"
    }

    fun loadPopularMovies() : LiveData<List<ListMoviesEntity>> {
        val list = MutableLiveData<List<ListMoviesEntity>>()
        try {
            ApiConfig.getApiService().getPopularMovies()
                    .enqueue(object : Callback<ListPopularMoviesResponse> {
                        override fun onFailure(call: Call<ListPopularMoviesResponse>, t: Throwable) {
                            Log.e(TAG, t.message.toString())
                        }

                        override fun onResponse(call: Call<ListPopularMoviesResponse>, response: Response<ListPopularMoviesResponse>) {
                            val movies = ArrayList<ListMoviesEntity>()
                            for (responses in response.body()?.results!!) {
                                movies.add(ListMoviesEntity(
                                        responses.id,
                                        responses.title,
                                        responses.releaseDate,
                                        "$BASE_IMAGE_URL${responses.posterPath}",

                                ))
                            }
                            list.postValue(movies)
                        }
                    })
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return list
    }

    fun loadDetailMovie(theId: Int) : LiveData<MovieEntity> {
        val movie = MutableLiveData<MovieEntity>()
        try {
            ApiConfig.getApiService().getDetailMovie(theId)
                .enqueue(object : Callback<DetailMovieResponse> {
                    override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
                        Log.e(TAG, t.message.toString())
                    }

                    override fun onResponse(
                        call: Call<DetailMovieResponse>,
                        response: Response<DetailMovieResponse>
                    ) {
                        movie.postValue(
                            MovieEntity(
                                "$BASE_IMAGE_URL${response.body()?.posterPath.toString()}",
                                response.body()?.title.toString(),
                                response.body()?.releaseDate.toString(),
                                response.body()?.genres?.get(0)?.name.toString(),
                                Duration().toPrint(response.body()?.runtime!!.toInt()),
                                response.body()?.voteAverage?.times(10)!!.toFloat(),
                                response.body()?.overview.toString()
                        )
                        )
                    }
                })
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
        }
        return movie
    }
}