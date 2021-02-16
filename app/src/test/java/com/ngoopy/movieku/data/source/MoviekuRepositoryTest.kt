package com.ngoopy.movieku.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.ngoopy.movieku.data.source.local.entity.ListMoviesEntity
import com.ngoopy.movieku.data.source.local.entity.ListTVShowsEntity
import com.ngoopy.movieku.data.source.local.entity.MovieEntity
import com.ngoopy.movieku.data.source.local.entity.TVShowEntity
import com.ngoopy.movieku.data.source.remote.RemoteDataSource
import com.ngoopy.movieku.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MoviekuRepositoryTest {
    private val remote = mock(RemoteDataSource::class.java)
    private val moviekuRepository = FakeMoviekuRepository(remote)
    private val dummyIdMovie = 464052
    private val dummyIdTVShow = 85271

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun getPopularMovies() {
        val remoteMovies = MutableLiveData<List<ListMoviesEntity>>()
        `when`(remote.getPopularMovies()).thenReturn(remoteMovies)

        val moviesEntity = MutableLiveData<List<ListMoviesEntity>>()
        moviesEntity.postValue(LiveDataTestUtil.getValue(moviekuRepository.getPopularMovies()))

        verify(remote).getPopularMovies()
        assertNotNull(moviesEntity)
        assertEquals(remoteMovies.value?.size?.toLong(), moviesEntity.value?.size?.toLong())
    }

    @Test
    fun getDetailMovie() {
        val remoteMovie = MutableLiveData<MovieEntity>()
        `when`(remote.getDetailMovie(dummyIdMovie)).thenReturn(remoteMovie)

        val movieEntity = MutableLiveData<MovieEntity>()
        movieEntity.postValue(LiveDataTestUtil.getValue(moviekuRepository.getDetailMovie(dummyIdMovie)))

        verify(remote).getDetailMovie(dummyIdMovie)
        assertNotNull(movieEntity)
        assertEquals(remoteMovie.value?.image.toString(), movieEntity.value?.image.toString())
        assertEquals(remoteMovie.value?.title.toString(), movieEntity.value?.title.toString())
        assertEquals(remoteMovie.value?.release_date.toString(), movieEntity.value?.release_date.toString())
        assertEquals(remoteMovie.value?.genre.toString(), movieEntity.value?.genre.toString())
        assertEquals(remoteMovie.value?.duration.toString(), movieEntity.value?.duration.toString())
        assertEquals(remoteMovie.value?.user_score, movieEntity.value?.user_score)
        assertEquals(remoteMovie.value?.kilasan.toString(), movieEntity.value?.kilasan.toString())
    }

    @Test
    fun getPopularTVShows() {
        val remoteTVShows = MutableLiveData<List<ListTVShowsEntity>>()
        `when`(remote.getPopularTVShows()).thenReturn(remoteTVShows)

        val tvshowsEntity = MutableLiveData<List<ListTVShowsEntity>>()
        tvshowsEntity.postValue(LiveDataTestUtil.getValue(moviekuRepository.getPopularTVShows()))

        verify(remote).getPopularTVShows()
        assertNotNull(tvshowsEntity)
        assertEquals(remoteTVShows.value?.size?.toLong(), tvshowsEntity.value?.size?.toLong())
    }

    @Test
    fun getDetailTVShow() {
        val remoteTVShow = MutableLiveData<TVShowEntity>()
        `when`(remote.getDetailTVShow(dummyIdTVShow)).thenReturn(remoteTVShow)

        val tvshowEntity = MutableLiveData<TVShowEntity>()
        tvshowEntity.postValue(LiveDataTestUtil.getValue(moviekuRepository.getDetailTVShow(dummyIdTVShow)))

        verify(remote).getDetailTVShow(dummyIdTVShow)
        assertNotNull(tvshowEntity)
        assertEquals(remoteTVShow.value?.image.toString(), tvshowEntity.value?.image.toString())
        assertEquals(remoteTVShow.value?.title.toString(), tvshowEntity.value?.title.toString())
        assertEquals(remoteTVShow.value?.genre.toString(), tvshowEntity.value?.genre.toString())
        assertEquals(remoteTVShow.value?.duration.toString(), tvshowEntity.value?.duration.toString())
        assertEquals(remoteTVShow.value?.kilasan.toString(), tvshowEntity.value?.kilasan.toString())
        assertEquals(remoteTVShow.value?.status.toString(), tvshowEntity.value?.status.toString())
        assertEquals(remoteTVShow.value?.network.toString(), tvshowEntity.value?.network.toString())
        assertEquals(remoteTVShow.value?.user_score, tvshowEntity.value?.user_score)
    }
}