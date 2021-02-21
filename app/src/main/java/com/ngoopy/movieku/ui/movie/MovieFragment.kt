package com.ngoopy.movieku.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ngoopy.movieku.databinding.FragmentMovieBinding
import com.ngoopy.movieku.viewmodel.ViewModelFactory
import com.ngoopy.movieku.vo.Status

class MovieFragment(private val favorite: Boolean) : Fragment() {
    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

            val movieAdapter = MovieAdapter()
            if (favorite) {
                viewModel.getBookmarkedMovies().observe(viewLifecycleOwner, { movies ->
                    binding?.progressBar?.visibility = View.GONE
                    movieAdapter.submitList(movies)
                })
            } else {
                viewModel.getPopularMovies().observe(viewLifecycleOwner, { movies ->
                    if (movies != null) {
                        when (movies.status) {
                            Status.LOADING -> binding?.progressBar?.visibility = View.VISIBLE
                            Status.SUCCESS -> {
                                binding?.progressBar?.visibility = View.GONE
                                movieAdapter.submitList(movies.data)
                            }
                            Status.ERROR -> {
                                binding?.progressBar?.visibility = View.GONE
                                Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })
            }
            with(binding?.rvMovies) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = movieAdapter
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}