package com.ngoopy.movieku.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ngoopy.movieku.data.source.MoviekuRepository
import com.ngoopy.movieku.di.Injection
import com.ngoopy.movieku.ui.movie.MovieViewModel

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
        when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(mMoviekuRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}