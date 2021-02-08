package com.ngoopy.movieku.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListTVShowsEntity(
    var id: Int,
    var title: String,
    var first_release_data: String,
    var poster_image: String
) : Parcelable