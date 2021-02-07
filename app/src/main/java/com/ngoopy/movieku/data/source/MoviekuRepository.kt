package com.ngoopy.movieku.data.source

import androidx.lifecycle.LiveData
import com.ngoopy.movieku.data.Entity.ListMoviesEntity
import com.ngoopy.movieku.data.source.remote.RemoteDataSource

class MoviekuRepository private constructor(private val remoteDataSource: RemoteDataSource) : MoviekuDataSource {
    companion object {
        @Volatile
        private var instance: MoviekuRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): MoviekuRepository =
            instance ?: synchronized(this) {
                instance ?: MoviekuRepository(remoteDataSource)
            }
    }

    override fun getPopularMovies(): LiveData<List<ListMoviesEntity>> = remoteDataSource.getPopularMovies()
}