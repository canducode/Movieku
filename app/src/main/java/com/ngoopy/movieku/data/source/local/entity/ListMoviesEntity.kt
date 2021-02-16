package com.ngoopy.movieku.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "listmovieentities")
@Parcelize
data class ListMoviesEntity(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "id")
        var id: Int,

        @ColumnInfo(name = "title")
        var title: String,

        @ColumnInfo(name = "release_date")
        var release_date: String,

        @ColumnInfo(name = "poster_image")
        var poster_image: String
) : Parcelable