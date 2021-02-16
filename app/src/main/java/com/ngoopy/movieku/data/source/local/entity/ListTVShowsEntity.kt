package com.ngoopy.movieku.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "listtvshowsentities")
@Parcelize
data class ListTVShowsEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "first_release_date")
    var first_release_date: String,

    @ColumnInfo(name = "poster_image")
    var poster_image: String
) : Parcelable