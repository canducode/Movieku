package com.ngoopy.movieku.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ngoopy.movieku.data.MoviekuRepository
import com.ngoopy.movieku.di.Injection
import com.ngoopy.movieku.ui.detail.DetailViewModel
import com.ngoopy.movieku.ui.movie.MovieViewModel
import com.ngoopy.movieku.ui.tv_show.TVShowViewModel

class ViewModelFactory private constructor(private val mMoviekuRepository: MoviekuRepository) : ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance : ViewModelFactory? = null

        fun getInstance(): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository())
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(mMoviekuRepository) as T
            }
            modelClass.isAssignableFrom(TVShowViewModel::class.java) -> {
                TVShowViewModel(mMoviekuRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(mMoviekuRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}