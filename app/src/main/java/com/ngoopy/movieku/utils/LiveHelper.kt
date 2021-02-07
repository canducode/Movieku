package com.ngoopy.movieku.utils

import androidx.lifecycle.MutableLiveData
import com.ngoopy.movieku.data.Entity.ListMoviesEntity

class LiveHelper {
    fun loadMovies() {
        val list = MutableLiveData<List<ListMoviesEntity>>()

    }
}