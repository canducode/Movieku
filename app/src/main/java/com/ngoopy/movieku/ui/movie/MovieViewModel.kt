package com.ngoopy.movieku.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.ngoopy.movieku.data.source.local.entity.ListMoviesEntity
import com.ngoopy.movieku.data.MoviekuRepository
import com.ngoopy.movieku.vo.Resource

class MovieViewModel(private val moviekuRepository: MoviekuRepository) : ViewModel() {
    fun getPopularMovies(): LiveData<Resource<PagedList<ListMoviesEntity>>> = moviekuRepository.getPopularMovies()
    fun getBookmarkedMovies(): LiveData<PagedList<ListMoviesEntity>> = moviekuRepository.getBookmarkedMovies()
}