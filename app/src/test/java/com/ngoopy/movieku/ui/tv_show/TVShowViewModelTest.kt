package com.ngoopy.movieku.ui.tv_show

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.ngoopy.movieku.data.source.local.entity.ListTVShowsEntity
import com.ngoopy.movieku.data.MoviekuRepository
import com.ngoopy.movieku.vo.Resource
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
    private lateinit var observerPopular: Observer<Resource<PagedList<ListTVShowsEntity>>>

    @Mock
    private lateinit var observerBookmark: Observer<PagedList<ListTVShowsEntity>>

    @Mock
    private lateinit var pagedList: PagedList<ListTVShowsEntity>

    @Before
    fun setUp() {
        viewModel = TVShowViewModel(moviekuRepository)
    }

    @Test
    fun getPopularTVShows() {
        val dummyTVShows = Resource.success(pagedList)
        `when`(dummyTVShows.data?.size).thenReturn(11)
        val tvshows = MutableLiveData<Resource<PagedList<ListTVShowsEntity>>>()
        tvshows.value = dummyTVShows

        `when`(moviekuRepository.getPopularTVShows()).thenReturn(tvshows)
        val tvShowsEntity = viewModel.getPopularTVShow().value?.data
        verify(moviekuRepository).getPopularTVShows()
        assertNotNull(tvShowsEntity)
        assertEquals(11, tvShowsEntity?.size)

        viewModel.getPopularTVShow().observeForever(observerPopular)
        verify(observerPopular).onChanged(dummyTVShows)
    }

    @Test
    fun getBookmarkedTVShows() {
        val dummmyTVShows = pagedList
        `when`(dummmyTVShows.size).thenReturn(11)
        val tvshows = MutableLiveData<PagedList<ListTVShowsEntity>>()
        tvshows.value = dummmyTVShows

        `when`(moviekuRepository.getBookmarkedTVShows()).thenReturn(tvshows)
        val tvShowsEntity = viewModel.getBookmarkedTVShows().value
        verify(moviekuRepository).getBookmarkedTVShows()
        assertNotNull(tvShowsEntity)
        assertEquals(11, tvShowsEntity?.size)

        viewModel.getBookmarkedTVShows().observeForever(observerBookmark)
        verify(observerBookmark).onChanged(dummmyTVShows)
    }
/*
    @Test
    fun getTVShow() {
        val dummyTVShows = DataDummy.generateDummyListTVShow()
        val tvshows = MutableLiveData<List<ListTVShowsEntity>>()
        tvshows.value = dummyTVShows

        `when`(moviekuRepository.getPopularTVShows()).thenReturn(tvshows)
        val listTVShowsEntity = viewModel.getPopularTVShow().value
        verify(moviekuRepository).getPopularTVShows()
        assertNotNull(listTVShowsEntity) // <- Mengecek Bahwa Data Tidak Null
        assertEquals(11, listTVShowsEntity?.size) // <- Membandingkan banyak data dengan expektasi hasil yang diharapkan

        viewModel.getPopularTVShow().observeForever(observer)
        verify(observer).onChanged(dummyTVShows)
    }*/
}