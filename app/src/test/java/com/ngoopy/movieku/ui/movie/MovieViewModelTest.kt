package com.ngoopy.movieku.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.ngoopy.movieku.data.source.local.entity.ListMoviesEntity
import com.ngoopy.movieku.data.MoviekuRepository
import com.ngoopy.movieku.utils.DataDummy
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
class MovieViewModelTest {
    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var moviekuRepository: MoviekuRepository

    @Mock
    private lateinit var observer: Observer<List<ListMoviesEntity>>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(moviekuRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = DataDummy.generateDummyListMovie() // <- Mengambil Data Dummy
        val movies = MutableLiveData<List<ListMoviesEntity>>()
        movies.value = dummyMovies

        `when`(moviekuRepository.getPopularMovies()).thenReturn(movies)
        val listMoviesEntity = viewModel.getPopularMovies().value
        verify(moviekuRepository).getPopularMovies()
        assertNotNull(listMoviesEntity) // <- Memastikan Bahwa Data Tidak Null
        assertEquals(12, listMoviesEntity?.size) // <- Membandingkan banyak data dengan expektasi hasil yang diharapkan

        viewModel.getPopularMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}