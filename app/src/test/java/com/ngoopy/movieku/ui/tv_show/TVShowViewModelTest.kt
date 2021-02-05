package com.ngoopy.movieku.ui.tv_show

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class TVShowViewModelTest {
    private lateinit var viewModel: TVShowViewModel

    @Before
    fun setUp() {
        viewModel = TVShowViewModel()
    }

    @Test
    fun getTVShow() {
        val tvshowEntity = viewModel.getTVShow()
        assertNotNull(tvshowEntity)
        assertEquals(11, tvshowEntity.size)
    }
}