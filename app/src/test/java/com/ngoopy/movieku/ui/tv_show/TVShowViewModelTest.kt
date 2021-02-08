package com.ngoopy.movieku.ui.tv_show

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.ngoopy.movieku.data.Entity.ListTVShowsEntity
import com.ngoopy.movieku.data.source.MoviekuRepository
import com.ngoopy.movieku.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TVShowViewModelTest {
    private lateinit var viewModel: TVShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var moviekuRepository: MoviekuRepository

    @Mock
    private lateinit var observer: Observer<List<ListTVShowsEntity>>

    @Before
    fun setUp() {
        viewModel = TVShowViewModel(moviekuRepository)
    }

    @Test
    fun getTVShow() {
        val dummyTVShows = DataDummy.generateDummyListTVShow()
        val tvshows = MutableLiveData<List<ListTVShowsEntity>>()
        tvshows.value = dummyTVShows

        `when`(moviekuRepository.getPopularTVShows()).thenReturn(tvshows)
        val listTVShowsEntity = viewModel.getPopularTVShow().value
        verify(moviekuRepository).getPopularTVShows()
        assertNotNull(listTVShowsEntity)
        assertEquals(11, listTVShowsEntity?.size)

        viewModel.getPopularTVShow().observeForever(observer)
        verify(observer).onChanged(dummyTVShows)
    }
}