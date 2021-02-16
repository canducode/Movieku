package com.ngoopy.movieku.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieentities")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "image")
    var image: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "release_date")
    var release_date : String,

    @ColumnInfo(name = "genre")
    var genre: String,

    @ColumnInfo(name = "duration")
    var duration: String,

    @ColumnInfo(name = "user_scrore")
    var user_score: Float,

    @ColumnInfo(name = "kilasan")
    var kilasan: String
)