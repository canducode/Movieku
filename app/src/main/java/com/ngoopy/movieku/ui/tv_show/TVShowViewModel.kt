package com.ngoopy.movieku.ui.tv_show

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ngoopy.movieku.data.source.local.entity.ListTVShowsEntity
import com.ngoopy.movieku.data.MoviekuRepository

class TVShowViewModel(private var moviekuRepository: MoviekuRepository) : ViewModel() {
    fun getPopularTVShow(): LiveData<List<ListTVShowsEntity>> = moviekuRepository.getPopularTVShows()
}