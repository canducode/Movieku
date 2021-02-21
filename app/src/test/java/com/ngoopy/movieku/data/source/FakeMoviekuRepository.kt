package com.ngoopy.movieku.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.ngoopy.movieku.data.MoviekuDataSource
import com.ngoopy.movieku.data.NetworkBoundResource
import com.ngoopy.movieku.data.source.local.LocalDataSource
import com.ngoopy.movieku.data.source.local.entity.ListMoviesEntity
import com.ngoopy.movieku.data.source.local.entity.ListTVShowsEntity
import com.ngoopy.movieku.data.source.local.entity.MovieEntity
import com.ngoopy.movieku.data.source.local.entity.TVShowEntity
import com.ngoopy.movieku.data.source.remote.ApiResponse
import com.ngoopy.movieku.data.source.remote.RemoteDataSource
import com.ngoopy.movieku.utils.AppExecutors
import com.ngoopy.movieku.vo.Resource

class FakeMoviekuRepository constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
    ) : MoviekuDataSource {

    override fun getPopularMovies(): LiveData<Resource<PagedList<ListMoviesEntity>>> {
        return object : NetworkBoundResource<PagedList<ListMoviesEntity>, List<ListMoviesEntity>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<ListMoviesEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setPageSize(10)
                    .build()
                return LivePagedListBuilder(localDataSource.getPopularMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<ListMoviesEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<ListMoviesEntity>>> =
                remoteDataSource.getPopularMovies()

            override fun saveCallResult(data: List<ListMoviesEntity>) {
                val movieList = ArrayList<ListMoviesEntity>()
                for (response in data) {
                    val movie = ListMoviesEntity(
                        response.id,
                        response.title,
                        response.release_date,
                        response.poster_image,
                        response.bookmarked
                    )
                    movieList.add(movie)
                }

                localDataSource.insertPopularMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getDetailMovie(movieId: Int): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, MovieEntity>(appExecutors) {
            override fun loadFromDB(): LiveData<MovieEntity> =
                localDataSource.getDetailMovie(movieId)

            override fun shouldFetch(data: MovieEntity?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<MovieEntity>> =
                remoteDataSource.getDetailMovie(movieId)

            override fun saveCallResult(data: MovieEntity) =
                localDataSource.insertDetailMovie(data)
        }.asLiveData()
    }

    override fun setMovieBookmark(movieId: Int, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setMovieBookmark(movieId, state) }

    override fun getBookmarkedMovies(): LiveData<PagedList<ListMoviesEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(10)
            .setPageSize(10)
            .build()
        return LivePagedListBuilder(localDataSource.getBookmarkedMovies(), config).build()
    }

    override fun getPopularTVShows(): LiveData<Resource<PagedList<ListTVShowsEntity>>> {
        return object : NetworkBoundResource<PagedList<ListTVShowsEntity>, List<ListTVShowsEntity>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<ListTVShowsEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setPageSize(10)
                    .build()
                return LivePagedListBuilder(localDataSource.getPopularTVShows(), config).build()
            }

            override fun shouldFetch(data: PagedList<ListTVShowsEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<ListTVShowsEntity>>> =
                remoteDataSource.getPopularTVShows()

            override fun saveCallResult(data: List<ListTVShowsEntity>) {
                val tvshowList = ArrayList<ListTVShowsEntity>()
                for (response in data) {
                    val tvshow = ListTVShowsEntity(
                        response.id,
                        response.title,
                        response.first_release_date,
                        response.poster_image,
                        response.bookmarked
                    )
                    tvshowList.add(tvshow)
                }

                localDataSource.insertPopularTVShows(tvshowList)
            }
        }.asLiveData()
    }

    override fun getDetailTVShow(tvshowId: Int): LiveData<Resource<TVShowEntity>> {
        return object : NetworkBoundResource<TVShowEntity, TVShowEntity>(appExecutors) {
            override fun loadFromDB(): LiveData<TVShowEntity> =
                localDataSource.getDetailTVShow(tvshowId)

            override fun shouldFetch(data: TVShowEntity?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<TVShowEntity>> =
                remoteDataSource.getDetailTVShow(tvshowId)

            override fun saveCallResult(data: TVShowEntity) =
                localDataSource.insertDetailTVShow(data)
        }.asLiveData()
    }

    override fun setTVShowBookmark(tvshowId: Int, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setTVShowsBookmark(tvshowId, state) }

    override fun getBookmarkedTVShows(): LiveData<PagedList<ListTVShowsEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(10)
            .setPageSize(10)
            .build()
        return LivePagedListBuilder(localDataSource.getBookmarkedTVShows(), config).build()
    }
}