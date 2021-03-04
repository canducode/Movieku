package com.ngoopy.movieku.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.ngoopy.movieku.data.source.local.LocalDataSource
import com.ngoopy.movieku.data.source.local.entity.ListMoviesEntity
import com.ngoopy.movieku.data.source.local.entity.ListTVShowsEntity
import com.ngoopy.movieku.data.source.local.entity.MovieEntity
import com.ngoopy.movieku.data.source.local.entity.TVShowEntity
import com.ngoopy.movieku.data.source.remote.RemoteDataSource
import com.ngoopy.movieku.utils.AppExecutors
import com.ngoopy.movieku.utils.DataDummy
import com.ngoopy.movieku.utils.LiveDataTestUtil
import com.ngoopy.movieku.utils.PagedListUtil
import com.ngoopy.movieku.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MoviekuRepositoryTest {
    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val moviekuRepository = FakeMoviekuRepository(remote, local, appExecutors)
    private val fakeMoviekuRepository = mock(FakeMoviekuRepository::class.java)
    private val movieId = 464052
    private val tvshowId = 85271

    private val movieResponse = DataDummy.generateDummyListMovie()
    private val tvshowResponse = DataDummy.generateDummyListTVShow()
    private val movieContent = DataDummy.generateDummyMovie()
    private val tvshowContent = DataDummy.generateDummyTVShow()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun getPopularMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, ListMoviesEntity>
        `when`(local.getPopularMovies()).thenReturn(dataSourceFactory)
        moviekuRepository.getPopularMovies()

        val moviesEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyListMovie()))
        verify(local).getPopularMovies()
        assertNotNull(moviesEntity.data)
        assertEquals(movieResponse.size.toLong(), moviesEntity.data?.size?.toLong())
    }

    @Test
    fun getDetailMovie() {
        val dummyEntity = MutableLiveData<MovieEntity>()
        dummyEntity.value = DataDummy.generateDummyMovie()[0]
        `when`(local.getDetailMovie(movieId)).thenReturn(dummyEntity)

        val movieEntitiesContent = LiveDataTestUtil.getValue(moviekuRepository.getDetailMovie(movieId))
        verify(local).getDetailMovie(movieId)
        assertNotNull(movieEntitiesContent)
        assertNotNull(movieEntitiesContent.data)
        assertEquals(movieContent[0], movieEntitiesContent.data)
    }

    @Test
    fun getBookmarkedMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, ListMoviesEntity>
        `when`(local.getBookmarkedMovies()).thenReturn(dataSourceFactory)
        moviekuRepository.getBookmarkedMovies()

        val moviesEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyListMovie()))
        verify(local).getBookmarkedMovies()
        assertNotNull(moviesEntity)
        assertEquals(movieResponse.size.toLong(), moviesEntity.data?.size?.toLong())
    }

    @Test
    fun getPopularTVShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, ListTVShowsEntity>
        `when`(local.getPopularTVShows()).thenReturn(dataSourceFactory)
        moviekuRepository.getPopularTVShows()

        val tvShowsEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyListTVShow()))
        verify(local).getPopularTVShows()
        assertNotNull(tvShowsEntity.data)
        assertEquals(tvshowResponse.size.toLong(), tvShowsEntity.data?.size?.toLong())
    }

    @Test
    fun getDetailTVShow() {
        val dummyEntity = MutableLiveData<TVShowEntity>()
        dummyEntity.value = DataDummy.generateDummyTVShow()[0]
        `when`(local.getDetailTVShow(tvshowId)).thenReturn(dummyEntity)

        val tvshowEntitiesContent = LiveDataTestUtil.getValue(moviekuRepository.getDetailTVShow(tvshowId))
        verify(local).getDetailTVShow(tvshowId)
        assertNotNull(tvshowEntitiesContent)
        assertNotNull(tvshowEntitiesContent.data)
        assertEquals(tvshowContent[0], tvshowEntitiesContent.data)
    }

    @Test
    fun getBookmarkedTVShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, ListTVShowsEntity>
        `when`(local.getBookmarkedTVShows()).thenReturn(dataSourceFactory)
        moviekuRepository.getBookmarkedTVShows()

        val tvShowsEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyListTVShow()))
        verify(local).getBookmarkedTVShows()
        assertNotNull(tvShowsEntity)
        assertEquals(tvshowResponse.size.toLong(), tvShowsEntity.data?.size?.toLong())
    }

    @Test
    fun setMovieBookmark() {
        val mockRepository = fakeMoviekuRepository
        Mockito.doNothing().`when`(mockRepository).setMovieBookmark(movieId, true)
        mockRepository.setMovieBookmark(movieId, true)

        verify(mockRepository).setMovieBookmark(movieId, true)
        Mockito.verify(mockRepository, Mockito.times(1)).setMovieBookmark(movieId, true)
    }

    @Test
    fun setTVShowBookmark() {
        val mockRepository = fakeMoviekuRepository
        Mockito.doNothing().`when`(mockRepository).setTVShowBookmark(tvshowId, true)
        mockRepository.setTVShowBookmark(tvshowId, true)

        verify(mockRepository).setTVShowBookmark(tvshowId, true)
        Mockito.verify(mockRepository, Mockito.times(1)).setTVShowBookmark(tvshowId, true)
    }
}