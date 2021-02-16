package com.ngoopy.movieku.di

import com.ngoopy.movieku.data.MoviekuRepository
import com.ngoopy.movieku.data.source.remote.RemoteDataSource
import com.ngoopy.movieku.utils.LiveHelper

object Injection {
    fun provideRepository(): MoviekuRepository {
        val remoteDataSource = RemoteDataSource.getInstance(LiveHelper())

        return MoviekuRepository.getInstance(remoteDataSource)
    }
}