package com.ngoopy.movieku.data.source.remote

import com.ngoopy.movieku.BuildConfig
import com.ngoopy.movieku.data.source.remote.response.DetailMovieResponse
import com.ngoopy.movieku.data.source.remote.response.DetailTVShowResponse
import com.ngoopy.movieku.data.source.remote.response.ListPopularMoviesResponse
import com.ngoopy.movieku.data.source.remote.response.ListPopularTVShowsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

const val API_KEY = BuildConfig.API_KEY

interface ApiService {

    @GET("movie/popular?api_key=$API_KEY&language=en-US&page=1")
    fun getPopularMovies() : Call<ListPopularMoviesResponse>

    @GET("movie/{id}?api_key=$API_KEY&language=en-US")
    fun getDetailMovie(
        @Path("id")id: Int
    ) : Call<DetailMovieResponse>

    @GET("tv/popular?api_key=$API_KEY&language=en-US&page=1")
    fun getPopularTVShows() : Call<ListPopularTVShowsResponse>

    @GET("tv/{id}?api_key=$API_KEY&language=en-US")
    fun getDetailTVShow(
        @Path("id")id: Int
    ) : Call<DetailTVShowResponse>
}