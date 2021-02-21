package com.ngoopy.movieku.ui.tv_show

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.ngoopy.movieku.data.source.local.entity.ListTVShowsEntity
import com.ngoopy.movieku.data.MoviekuRepository
import com.ngoopy.movieku.vo.Resource

class TVShowViewModel(private var moviekuRepository: MoviekuRepository) : ViewModel() {
    fun getPopularTVShow(): LiveData<Resource<PagedList<ListTVShowsEntity>>> = moviekuRepository.getPopularTVShows()
    fun getBookmarkedTVShows(): LiveData<PagedList<ListTVShowsEntity>> = moviekuRepository.getBookmarkedTVShows()
}