package com.ngoopy.movieku.ui.detail

import androidx.lifecycle.Observer
import com.ngoopy.movieku.data.entity.MovieEntity
import com.ngoopy.movieku.data.entity.TVShowEntity
import com.ngoopy.movieku.data.source.MoviekuRepository
import com.ngoopy.movieku.utils.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mock

class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel
    private val position = 0
    private val dummyMovie = DataDummy.generateDummyMovie()[position]
    private val dummyTVShow = DataDummy.generateDummyTVShow()[position]

    @Mock
    private lateinit var moviekuRepository: MoviekuRepository

    @Mock
    private lateinit var movieObserver: Observer<MovieEntity>
    
    @Mock
    private lateinit var tvshowObserver: Observer<TVShowEntity>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(moviekuRepository)

    }

    @Test
    fun getMovie() {
/*        val movieEntity = viewModel.getMovie(position) // <- Mengambil Data
        assertNotNull(movieEntity) // <- Mengecek Bahwa Data Tidak Null
        assertEquals(dummyMovie.image, movieEntity.image) // <- Membandingkan data dengan expektasi hasil yang diharapkan
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.release_date, movieEntity.release_date)
        assertEquals(dummyMovie.genre, movieEntity.genre)
        assertEquals(dummyMovie.duration, movieEntity.duration)
        assertEquals(dummyMovie.user_score, movieEntity.user_score)
        assertEquals(dummyMovie.kilasan, movieEntity.kilasan)*/
    }

    @Test
    fun getTVShow() {
/*        val tvshowEntity = viewModel.getTVShow(position) // <- Mengambil Data
        assertNotNull(tvshowEntity) // <- Mengecek Bahwa Data Tidak Null
        assertEquals(dummyTVShow.image, tvshowEntity.image) // <- Membandingkan data dengan expektasi hasil yang diharapkan
        assertEquals(dummyTVShow.title, tvshowEntity.title)
        assertEquals(dummyTVShow.status, tvshowEntity.status)
        assertEquals(dummyTVShow.genre, tvshowEntity.genre)
        assertEquals(dummyTVShow.duration, tvshowEntity.duration)
        assertEquals(dummyTVShow.network, tvshowEntity.network)
        assertEquals(dummyTVShow.user_score, tvshowEntity.user_score)
        assertEquals(dummyTVShow.kilasan, tvshowEntity.kilasan)*/
    }
}