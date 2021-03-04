package com.ngoopy.movieku.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.ngoopy.movieku.data.source.local.entity.MovieEntity
import com.ngoopy.movieku.data.source.local.entity.TVShowEntity
import com.ngoopy.movieku.data.MoviekuRepository
import com.ngoopy.movieku.utils.DataDummy
import com.ngoopy.movieku.vo.Resource
import org.junit.Before
import org.junit.Test

import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel
    private val position = 0
    private val dummyMovie = DataDummy.generateDummyMovie()[position]
    private val dummyTVShow = DataDummy.generateDummyTVShow()[position]

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var moviekuRepository: MoviekuRepository

    @Mock
    private lateinit var movieObserver: Observer<Resource<MovieEntity>>

    @Mock
    private lateinit var tvshowObserver: Observer<Resource<TVShowEntity>>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(moviekuRepository)
    }

    @Test
    fun getDetailMovie() {
        val dummyMovie = Resource.success(dummyMovie)
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = dummyMovie

        `when`(moviekuRepository.getDetailMovie(position)).thenReturn(movie)

        viewModel.getDetailMovie(position).observeForever(movieObserver)

        verify(movieObserver).onChanged(dummyMovie)
    }

    @Test
    fun getDetailTVShow() {
        val dummyTVShow = Resource.success(dummyTVShow)
        val tvshow = MutableLiveData<Resource<TVShowEntity>>()
        tvshow.value = dummyTVShow

        `when`(moviekuRepository.getDetailTVShow(position)).thenReturn(tvshow)

        viewModel.getDetailTVShow(position).observeForever(tvshowObserver)

        verify(tvshowObserver).onChanged(dummyTVShow)
    }

    @Test
    fun setBookmarkMovie() {
        val detailViewModel = mock(DetailViewModel::class.java)
        doNothing().`when`(detailViewModel).setBookmarkMovie(dummyMovie.id, true)
        detailViewModel.setBookmarkMovie(dummyMovie.id, true)

        verify(detailViewModel, times(1)).setBookmarkMovie(dummyMovie.id, true)
    }

    @Test
    fun setBookmarkTVShow() {
        val detailViewModel = mock(DetailViewModel::class.java)
        doNothing().`when`(detailViewModel).setBookmarkTVShow(dummyTVShow.id, true)
        detailViewModel.setBookmarkTVShow(dummyTVShow.id, true)

        verify(detailViewModel, times(1)).setBookmarkTVShow(dummyTVShow.id, true)
    }
}