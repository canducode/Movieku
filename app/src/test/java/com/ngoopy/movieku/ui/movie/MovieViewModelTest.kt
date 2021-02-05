package com.ngoopy.movieku.ui.movie

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class MovieViewModelTest {
    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {
        viewModel = MovieViewModel()
    }

    @Test
    fun getMovies() {
        val movieEntity = viewModel.getMovies()  // <- Mengambil Data
        assertNotNull(movieEntity) // <- Mengecek Bahwa Data Tidak Null
        assertEquals(12, movieEntity.size) // <- Membandingkan banyak data dengan expektasi hasil yang diharapkan
    }
}