package com.ngoopy.movieku.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ngoopy.movieku.data.source.local.entity.ListMoviesEntity
import com.ngoopy.movieku.data.source.local.entity.ListTVShowsEntity
import com.ngoopy.movieku.data.source.local.entity.MovieEntity
import com.ngoopy.movieku.data.source.local.entity.TVShowEntity

@Database(entities = [ListMoviesEntity::class, MovieEntity::class, ListTVShowsEntity::class, TVShowEntity::class], version = 1, exportSchema = false)
abstract class MoviekuDatabase : RoomDatabase() {
    abstract fun moviekuDao(): MoviekuDao
    companion object {
        @Volatile
        private var INSTANCE: MoviekuDatabase? = null

        fun getInstance(context: Context): MoviekuDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(context.applicationContext,
                MoviekuDatabase::class.java, "Movieku.db").build()
            }
    }
}