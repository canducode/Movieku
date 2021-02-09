package com.ngoopy.movieku.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.test.espresso.IdlingRegistry
import com.ngoopy.movieku.data.entity.MovieEntity
import com.ngoopy.movieku.data.entity.TVShowEntity
import com.ngoopy.movieku.data.source.MoviekuRepository
import com.ngoopy.movieku.utils.DataDummy
import com.ngoopy.movieku.utils.EspressoIdlingResource
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
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
    private lateinit var movieObserver: Observer<MovieEntity>

    @Mock
    private lateinit var tvshowObserver: Observer<TVShowEntity>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(moviekuRepository)
    }

    @Test
    fun getMovie() {
        val movie = MutableLiveData<MovieEntity>()
        movie.value = dummyMovie

        `when`(moviekuRepository.getDetailMovie(position)).thenReturn(movie)
        val movieEntity = viewModel.getMovie(position).value as MovieEntity
        verify(moviekuRepository).getDetailMovie(position)
        assertNotNull(movieEntity) // <- Mengecek Bahwa Data Tidak Null

        // -- Membandingkan data dengan expektasi hasil yang diharapkan
        assertEquals(dummyMovie.image, movieEntity.image)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.release_date, movieEntity.release_date)
        assertEquals(dummyMovie.genre, movieEntity.genre)
        assertEquals(dummyMovie.duration, movieEntity.duration)
        assertEquals(dummyMovie.user_score, movieEntity.user_score)
        assertEquals(dummyMovie.kilasan, movieEntity.kilasan)

        viewModel.getMovie(position).observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }

    @Test
    fun getTVShow() {
        val tvshow = MutableLiveData<TVShowEntity>()
        tvshow.value = dummyTVShow

        `when`(moviekuRepository.getDetailTVShow(position)).thenReturn(tvshow)
        val tvshowEntity = viewModel.getTVShow(position).value as TVShowEntity
        verify(moviekuRepository).getDetailTVShow(position)
        assertNotNull(tvshowEntity) // <- Mengecek Bahwa Data Tidak Null

        // -- Membandingkan data dengan expektasi hasil yang diharapkan
        assertEquals(dummyTVShow.image, tvshowEntity.image)
        assertEquals(dummyTVShow.title, tvshowEntity.title)
        assertEquals(dummyTVShow.status, tvshowEntity.status)
        assertEquals(dummyTVShow.genre, tvshowEntity.genre)
        assertEquals(dummyTVShow.duration, tvshowEntity.duration)
        assertEquals(dummyTVShow.network, tvshowEntity.network)
        assertEquals(dummyTVShow.user_score, tvshowEntity.user_score)
        assertEquals(dummyTVShow.kilasan, tvshowEntity.kilasan)

        viewModel.getTVShow(position).observeForever(tvshowObserver)
        verify(tvshowObserver).onChanged(dummyTVShow)
    }
}