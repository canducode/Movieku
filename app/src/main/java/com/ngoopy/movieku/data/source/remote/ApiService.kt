package com.ngoopy.movieku.data.source.remote

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("")
    fun getMovies() : Call<>
}