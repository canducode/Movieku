package com.ngoopy.movieku.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ngoopy.movieku.data.source.local.entity.MovieEntity
import com.ngoopy.movieku.data.source.local.entity.TVShowEntity
import com.ngoopy.movieku.data.MoviekuRepository
import com.ngoopy.movieku.vo.Resource

class DetailViewModel(private val moviekuRepository: MoviekuRepository) : ViewModel() {
    fun getDetailMovie(movieId: Int): LiveData<Resource<MovieEntity>> = moviekuRepository.getDetailMovie(movieId)
    fun getDetailTVShow(tvshowId: Int): LiveData<Resource<TVShowEntity>> = moviekuRepository.getDetailTVShow(tvshowId)

    fun setBookmarkMovie(movieId: Int, newState: Boolean) {
        moviekuRepository.setMovieBookmark(movieId, newState)
    }

    fun setBookmarkTVShow(tvshowId: Int, newState: Boolean) {
        moviekuRepository.setTVShowBookmark(tvshowId, newState)
    }
}