package com.ngoopy.movieku.ui.detail

import com.ngoopy.movieku.utils.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel
    private val position = 0
    private val dummyMovie = DataDummy.generateDummyMovie()[position]
    private val dummyTVShow = DataDummy.generateDummyTVShow()[position]

    @Before
    fun setUp() {
        viewModel = DetailViewModel()
    }

    @Test
    fun getMovie() {
        val movieEntity = viewModel.getMovie(position) // <- Mengambil Data
        assertNotNull(movieEntity) // <- Mengecek Bahwa Data Tidak Null
        assertEquals(dummyMovie.image, movieEntity.image) // <- Membandingkan data dengan expektasi hasil yang diharapkan
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.release_date, movieEntity.release_date)
        assertEquals(dummyMovie.genre, movieEntity.genre)
        assertEquals(dummyMovie.duration, movieEntity.duration)
        assertEquals(dummyMovie.user_score, movieEntity.user_score)
        assertEquals(dummyMovie.kilasan, movieEntity.kilasan)
    }

    @Test
    fun getTVShow() {
        val tvshowEntity = viewModel.getTVShow(position) // <- Mengambil Data
        assertNotNull(tvshowEntity) // <- Mengecek Bahwa Data Tidak Null
        assertEquals(dummyTVShow.image, tvshowEntity.image) // <- Membandingkan data dengan expektasi hasil yang diharapkan
        assertEquals(dummyTVShow.title, tvshowEntity.title)
        assertEquals(dummyTVShow.status, tvshowEntity.status)
        assertEquals(dummyTVShow.genre, tvshowEntity.genre)
        assertEquals(dummyTVShow.duration, tvshowEntity.duration)
        assertEquals(dummyTVShow.network, tvshowEntity.network)
        assertEquals(dummyTVShow.user_score, tvshowEntity.user_score)
        assertEquals(dummyTVShow.kilasan, tvshowEntity.kilasan)
    }
}