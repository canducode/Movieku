package com.ngoopy.movieku.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ngoopy.movieku.R
import com.ngoopy.movieku.data.source.local.entity.MovieEntity
import com.ngoopy.movieku.data.source.local.entity.TVShowEntity
import com.ngoopy.movieku.databinding.ActivityDetailBinding
import com.ngoopy.movieku.viewmodel.ViewModelFactory

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_TYPE = "extra_type"
        const val EXTRA_THEID = "extra_THEID"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.toolbarDetail.setNavigationOnClickListener { finish() }

        val factory = ViewModelFactory.getInstance()
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val type = extras.getString(EXTRA_TYPE,"TV Show")
            binding.toolbarDetail.title = "Detail $type"

            binding.shimmerLoading.startShimmer()
            val theId = extras.getInt(EXTRA_THEID)
            if (type == "Movie"){
                viewModel.getMovie(theId).observe(this, {
                    if (it != null) {
                        setMovie(it)
                    }
                })
            } else {
                viewModel.getTVShow(theId).observe(this, {
                    if (it != null) {
                        setTVShow(it)
                    }
                })
            }
        }
    }

    private fun setMovie(movieEntity: MovieEntity) {
        binding.contentDetail.trNetwork.visibility = View.GONE
        setData(movieEntity.image, movieEntity.title, movieEntity.release_date, movieEntity.genre, movieEntity.duration, movieEntity.kilasan, movieEntity.user_score)
    }

    private fun setTVShow(tvShowEntity: TVShowEntity) {
        setData( tvShowEntity.image, tvShowEntity.title, tvShowEntity.status, tvShowEntity.genre,tvShowEntity.duration,tvShowEntity.kilasan,tvShowEntity.user_score)
        Glide.with(this)
            .load(tvShowEntity.network)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
            .into(binding.contentDetail.ivNetwork)
    }

    private fun setData(image: String, title: String, release: String, genre: String, duration: String, kilasan: String, user_score: Float) {
        binding.contentDetail.apply {
            Glide.with(this@DetailActivity)
                .load(image)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(ivImage)

            Glide.with(this@DetailActivity)
                .load(image)
                .apply(RequestOptions().override(10,15).placeholder(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(ivImageBlur)

            tvTitle.text = title
            tvReleaseDate.text = release
            tvGenre.text = genre
            tvDuration.text = duration
            tvKilasan.text = kilasan
            cpbUserScore.progress = user_score
        }

        binding.apply {
            shimmerLoading.stopShimmer()
            shimmerLoading.hideShimmer()
        }
    }

}