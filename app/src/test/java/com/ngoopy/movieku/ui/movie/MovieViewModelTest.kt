package com.ngoopy.movieku.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.ngoopy.movieku.data.source.local.entity.ListMoviesEntity
import com.ngoopy.movieku.data.MoviekuRepository
import com.ngoopy.movieku.utils.DataDummy
import com.ngoopy.movieku.vo.Resource
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
    private lateinit var observerPopular: Observer<Resource<PagedList<ListMoviesEntity>>>

    @Mock
    private lateinit var observerBookmark: Observer<PagedList<ListMoviesEntity>>

    @Mock
    private lateinit var pagedList: PagedList<ListMoviesEntity>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(moviekuRepository)
    }

    @Test
    fun getPopularMovies() {
        val dummyMovies = Resource.success(pagedList)
        `when`(dummyMovies.data?.size).thenReturn(11)
        val movies = MutableLiveData<Resource<PagedList<ListMoviesEntity>>>()
        movies.value = dummyMovies

        `when`(moviekuRepository.getPopularMovies()).thenReturn(movies)
        val moviesEntity = viewModel.getPopularMovies().value?.data
        verify(moviekuRepository).getPopularMovies()
        assertNotNull(moviesEntity)
        assertEquals(11, moviesEntity?.size)

        viewModel.getPopularMovies().observeForever(observerPopular)
        verify(observerPopular).onChanged(dummyMovies)

        /*
        val dummyMovies = DataDummy.generateDummyListMovie() // <- Mengambil Data Dummy
        val movies = MutableLiveData<List<ListMoviesEntity>>()
        movies.value = dummyMovies

        `when`(moviekuRepository.getPopularMovies()).thenReturn(movies)
        val listMoviesEntity = viewModel.getPopularMovies().value
        verify(moviekuRepository).getPopularMovies()
        assertNotNull(listMoviesEntity) // <- Memastikan Bahwa Data Tidak Null
        assertEquals(12, listMoviesEntity?.size) // <- Membandingkan banyak data dengan expektasi hasil yang diharapkan

        viewModel.getPopularMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)*/
    }

    @Test
    fun getBookmarkedMovies() {
        val dummyMovies = pagedList
        `when`(dummyMovies.size).thenReturn(11)
        val movies = MutableLiveData<PagedList<ListMoviesEntity>>()
        movies.value = dummyMovies

        `when`(moviekuRepository.getBookmarkedMovies()).thenReturn(movies)
        val moviesEntity = viewModel.getBookmarkedMovies().value
        verify(moviekuRepository).getBookmarkedMovies()
        assertNotNull(moviesEntity)
        assertEquals(11, moviesEntity?.size)

        viewModel.getBookmarkedMovies().observeForever(observerBookmark)
        verify(observerBookmark).onChanged(dummyMovies)
    }
}