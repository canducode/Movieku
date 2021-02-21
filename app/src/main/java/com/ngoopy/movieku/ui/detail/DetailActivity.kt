package com.ngoopy.movieku.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ngoopy.movieku.R
import com.ngoopy.movieku.data.source.local.entity.MovieEntity
import com.ngoopy.movieku.data.source.local.entity.TVShowEntity
import com.ngoopy.movieku.databinding.ActivityDetailBinding
import com.ngoopy.movieku.viewmodel.ViewModelFactory

class DetailActivity : AppCompatActivity() {
    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding

    private lateinit var viewModel: DetailViewModel
    private var state = false
    private lateinit var type: String

    companion object {
        const val EXTRA_TYPE = "extra_type"
        const val EXTRA_THEID = "extra_theid"
        const val EXTRA_STATE = "extra_state"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        supportActionBar?.hide()
        binding?.toolbarDetail?.setNavigationOnClickListener { finish() }

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            state = extras.getBoolean(EXTRA_STATE)
            if (state) binding?.contentDetail?.btnFavorite?.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.ic_favorite, null))

            type = extras.getString(EXTRA_TYPE,"TV Show")
            binding?.toolbarDetail?.title = "Detail $type"

            binding?.shimmerLoading?.startShimmer()
            val theId = extras.getInt(EXTRA_THEID)
            if (type == "Movie"){
                viewModel.getDetailMovie(theId).observe(this, {
                    if (it.data != null) {
                        setMovie(it.data)
                    }
                })
            } else {
                viewModel.getDetailTVShow(theId).observe(this, {
                    if (it.data != null) {
                        setTVShow(it.data)
                    }
                })
            }
        }

        binding?.contentDetail?.btnFavorite?.setOnClickListener {
            setBookmarkState()
        }
    }

    private fun setMovie(movieEntity: MovieEntity) {
        binding?.contentDetail?.trNetwork?.visibility = View.GONE
        setData(movieEntity.image, movieEntity.title, movieEntity.release_date, movieEntity.genre, movieEntity.duration, movieEntity.kilasan, movieEntity.user_score)
    }

    private fun setTVShow(tvShowEntity: TVShowEntity) {
        setData( tvShowEntity.image, tvShowEntity.title, tvShowEntity.status, tvShowEntity.genre,tvShowEntity.duration,tvShowEntity.kilasan,tvShowEntity.user_score)
        Glide.with(this)
            .load(tvShowEntity.network)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
            .into(binding?.contentDetail!!.ivNetwork)
    }

    private fun setData(image: String, title: String, release: String, genre: String, duration: String, kilasan: String, user_score: Float) {
        binding?.contentDetail?.apply {
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

        binding?.apply {
            shimmerLoading.stopShimmer()
            shimmerLoading.hideShimmer()
        }
    }

    private fun setBookmarkState() {
        state = !state
        if (state) {
            binding?.contentDetail?.btnFavorite?.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.ic_favorite, null))
        } else {
            binding?.contentDetail?.btnFavorite?.setImageDrawable(ResourcesCompat.getDrawable(resources, R.drawable.ic_favorite_border, null))
        }
        if (type == "Movie") {
            viewModel.setBookmarkMovie(intent.extras!!.getInt(EXTRA_THEID), state)
        } else {
            viewModel.setBookmarkTVShow(intent.extras!!.getInt(EXTRA_THEID), state)
        }
    }
}