package com.ngoopy.movieku.ui.detail

import androidx.lifecycle.ViewModel
import com.ngoopy.movieku.data.Entity.MovieEntity
import com.ngoopy.movieku.data.Entity.TVShowEntity
import com.ngoopy.movieku.utils.DataDummy

class DetailViewModel : ViewModel() {
    fun getMovie(position: Int): MovieEntity = DataDummy.generateDummyMovie()[position]
    fun getTVShow(position: Int): TVShowEntity = DataDummy.generateDummyTVShow()[position]
}