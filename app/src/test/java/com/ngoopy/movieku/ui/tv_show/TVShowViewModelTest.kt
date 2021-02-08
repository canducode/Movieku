package com.ngoopy.movieku.ui.tv_show

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.ngoopy.movieku.data.Entity.ListTVShowsEntity
import com.ngoopy.movieku.data.source.MoviekuRepository
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
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
        val tvshowEntity = viewModel.getTVShow()
        assertNotNull(tvshowEntity)
        assertEquals(11, tvshowEntity.size)
    }
}