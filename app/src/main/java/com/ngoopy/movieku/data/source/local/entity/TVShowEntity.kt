package com.ngoopy.movieku.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tvshowentities")
data class TVShowEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "image")
    var image: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "genre")
    var genre: String,

    @ColumnInfo(name = "duration")
    var duration: String,

    @ColumnInfo(name = "kilasan")
    var kilasan: String,

    @ColumnInfo(name = "status")
    var status: String,

    @ColumnInfo(name = "network")
    var network: String,

    @ColumnInfo(name = "user_score")
    var user_score: Float
)
