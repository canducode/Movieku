package com.ngoopy.movieku.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListMoviesEntity(
    var id: Int,
    var title: String,
    var release_date: String,
    var poster_image: String
) : Parcelable