package com.ngoopy.movieku.data.source.local.room


import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.*
import com.ngoopy.movieku.data.source.local.entity.ListMoviesEntity
import com.ngoopy.movieku.data.source.local.entity.ListTVShowsEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM listmovieentities")
    fun getPopularMovie(): DataSource.Factory<Int, ListMoviesEntity>

    @Query("SELECT * FROM listtvshowsentities")
    fun getPopularTVShow(): DataSource.Factory<Int, ListTVShowsEntity>

    
}