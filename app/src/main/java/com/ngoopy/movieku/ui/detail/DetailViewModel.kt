package com.ngoopy.movieku.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ngoopy.movieku.data.Entity.MovieEntity
import com.ngoopy.movieku.data.Entity.TVShowEntity
import com.ngoopy.movieku.data.source.MoviekuRepository
import com.ngoopy.movieku.utils.DataDummy

class DetailViewModel(private val moviekuRepository: MoviekuRepository) : ViewModel() {
    fun getMovie(theId: Int): LiveData<MovieEntity> = moviekuRepository.getDetailMovie(theId)
    fun getTVShow(position: Int): TVShowEntity = DataDummy.generateDummyTVShow()[position]
}