package com.ngoopy.movieku.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ngoopy.movieku.data.source.local.entity.MovieEntity
import com.ngoopy.movieku.data.source.local.entity.TVShowEntity
import com.ngoopy.movieku.data.MoviekuRepository

class DetailViewModel(private val moviekuRepository: MoviekuRepository) : ViewModel() {
    fun getMovie(theId: Int): LiveData<MovieEntity> = moviekuRepository.getDetailMovie(theId)
    fun getTVShow(theId: Int): LiveData<TVShowEntity> = moviekuRepository.getDetailTVShow(theId)
}