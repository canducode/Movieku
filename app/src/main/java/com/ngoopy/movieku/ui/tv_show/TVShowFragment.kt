package com.ngoopy.movieku.ui.tv_show

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ngoopy.movieku.databinding.FragmentTvShowBinding
import com.ngoopy.movieku.viewmodel.ViewModelFactory
import com.ngoopy.movieku.vo.Status

class TVShowFragment(private val favorite: Boolean) : Fragment() {
    private var _binding: FragmentTvShowBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTvShowBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TVShowViewModel::class.java]

            val tvshowAdapter = TVShowAdapter()
            if (favorite) {
                viewModel.getBookmarkedTVShows().observe(viewLifecycleOwner, { tvshows ->
                    binding?.progressBar?.visibility = View.GONE
                    tvshowAdapter.submitList(tvshows)
                })
            } else {
                viewModel.getPopularTVShow().observe(viewLifecycleOwner, { tvshows ->
                    if (tvshows != null) {
                        when (tvshows.status) {
                            Status.LOADING -> binding?.progressBar?.visibility = View.VISIBLE
                            Status.SUCCESS -> {
                                binding?.progressBar?.visibility = View.GONE
                                tvshowAdapter.submitList(tvshows.data)
                            }
                            Status.ERROR -> {
                                binding?.progressBar?.visibility = View.GONE
                                Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                })
            }
            with(binding?.rvTvShows) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = tvshowAdapter
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}