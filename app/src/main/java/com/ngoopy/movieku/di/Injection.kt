package com.ngoopy.movieku.di

import android.content.Context
import com.ngoopy.movieku.data.MoviekuRepository
import com.ngoopy.movieku.data.source.local.LocalDataSource
import com.ngoopy.movieku.data.source.local.room.MoviekuDatabase
import com.ngoopy.movieku.data.source.remote.RemoteDataSource
import com.ngoopy.movieku.utils.AppExecutors
import com.ngoopy.movieku.utils.LiveHelper

object Injection {
    fun provideRepository(context: Context): MoviekuRepository {

        val database = MoviekuDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(LiveHelper())
        val localDataSource = LocalDataSource.getInstance(database.moviekuDao())
        val appExecutors = AppExecutors()

        return MoviekuRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}