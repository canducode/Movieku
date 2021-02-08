package com.ngoopy.movieku.utils

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ngoopy.movieku.data.entity.ListMoviesEntity
import com.ngoopy.movieku.data.entity.ListTVShowsEntity
import com.ngoopy.movieku.data.entity.MovieEntity
import com.ngoopy.movieku.data.entity.TVShowEntity
import com.ngoopy.movieku.data.source.remote.response.DetailMovieResponse
import com.ngoopy.movieku.data.source.remote.response.DetailTVShowResponse
import com.ngoopy.movieku.data.source.remote.response.ListPopularMoviesResponse
import com.ngoopy.movieku.data.source.remote.response.ListPopularTVShowsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LiveHelper {
    companion object {
        private val TAG = LiveHelper::class.java.simpleName
        private const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500"
    }

    fun loadPopularMovies() : LiveData<List<ListMoviesEntity>> {
        EspressoIdlingResource.increment()
        val list = MutableLiveData<List<ListMoviesEntity>>()
        try {
            ApiConfig.getApiService().getPopularMovies()
                    .enqueue(object : Callback<ListPopularMoviesResponse> {
                        override fun onFailure(call: Call<ListPopularMoviesResponse>, t: Throwable) {
                            Log.e(TAG, t.message.toString())
                            EspressoIdlingResource.decrement()
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
                            EspressoIdlingResource.decrement()
                        }
                    })
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return list
    }

    fun loadDetailMovie(theId: Int) : LiveData<MovieEntity> {
        EspressoIdlingResource.increment()
        val movie = MutableLiveData<MovieEntity>()
        try {
            ApiConfig.getApiService().getDetailMovie(theId)
                .enqueue(object : Callback<DetailMovieResponse> {
                    override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
                        Log.e(TAG, t.message.toString())
                        EspressoIdlingResource.decrement()
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
                                Duration().toPrint(response.body()?.runtime?.toInt()?:0),
                                response.body()?.voteAverage?.times(10)?.toFloat()?:0f,
                                response.body()?.overview.toString()
                        )
                        )
                        EspressoIdlingResource.decrement()
                    }
                })
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
        }
        return movie
    }

    fun loadPopularTVShows() : LiveData<List<ListTVShowsEntity>> {
        EspressoIdlingResource.increment()
        val list = MutableLiveData<List<ListTVShowsEntity>>()
        try {
            ApiConfig.getApiService().getPopularTVShows()
                .enqueue(object : Callback<ListPopularTVShowsResponse> {
                    override fun onFailure(call: Call<ListPopularTVShowsResponse>, t: Throwable) {
                        Log.e(TAG, t.message.toString())
                        EspressoIdlingResource.decrement()
                    }

                    override fun onResponse(
                        call: Call<ListPopularTVShowsResponse>,
                        response: Response<ListPopularTVShowsResponse>
                    ) {
                        val tvshows = ArrayList<ListTVShowsEntity>()
                        for (responses in response.body()?.results!!) {
                            tvshows.add(ListTVShowsEntity(
                                responses.id,
                                responses.name,
                                responses.firstAirDate,
                                "$BASE_IMAGE_URL${responses.posterPath}",
                            ))
                        }
                        list.postValue(tvshows)
                        EspressoIdlingResource.decrement()
                    }
                })
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
        }
        return list
    }

    fun loadDetailTVShow(theId: Int) : LiveData<TVShowEntity> {
        EspressoIdlingResource.increment()
        val tvshow = MutableLiveData<TVShowEntity>()
        try {
            ApiConfig.getApiService().getDetailTVShow(theId)
                .enqueue(object : Callback<DetailTVShowResponse> {
                    override fun onFailure(call: Call<DetailTVShowResponse>, t: Throwable) {
                        Log.e(TAG, t.message.toString())
                        EspressoIdlingResource.decrement()
                    }

                    override fun onResponse(
                        call: Call<DetailTVShowResponse>,
                        response: Response<DetailTVShowResponse>
                    ) {
                        tvshow.postValue(
                            TVShowEntity(
                                "$BASE_IMAGE_URL${response.body()?.posterPath.toString()}",
                                response.body()?.name.toString(),
                                response.body()?.genres?.get(0)?.name.toString(),
                                Duration().toPrint(
                                    response.body()?.episodeRunTime?.get(0)!!.toInt()
                                ),
                                response.body()?.overview.toString(),
                                response.body()?.status.toString(),
                                "$BASE_IMAGE_URL${response.body()?.networks?.get(0)?.logoPath.toString()}",
                                response.body()?.voteAverage?.times(10)!!.toFloat()
                            )
                        )
                        EspressoIdlingResource.decrement()
                    }
                })
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
        }
        return tvshow
    }
}