package com.ngoopy.movieku.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ngoopy.movieku.R
import com.ngoopy.movieku.data.Entity.MovieEntity
import com.ngoopy.movieku.data.Entity.TVShowEntity
import com.ngoopy.movieku.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_TYPE = "extra_type"
        const val EXTRA_POSITION = "extra_position"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.toolbarDetail.setNavigationOnClickListener { finish() }

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val type = extras.getString(EXTRA_TYPE,"TV Show")
            val position = extras.getInt(EXTRA_POSITION,0)
            binding.toolbarDetail.title = "Detail $type"

            if (type == "Movie"){
                setMovie(viewModel.getMovie(position))
            } else {
                setTVShow(viewModel.getTVShow(position))
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
        Glide.with(this)
            .load(image)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
            .into(binding.contentDetail.ivImage)

        Glide.with(this)
            .load(image)
            .apply(RequestOptions().override(10,15).placeholder(R.drawable.ic_loading).error(R.drawable.ic_error))
            .into(binding.contentDetail.ivImageBlur)

        binding.contentDetail.tvTitle.text = title
        binding.contentDetail.tvReleaseDate.text = release
        binding.contentDetail.tvGenre.text = genre
        binding.contentDetail.tvDuration.text = duration
        binding.contentDetail.tvKilasan.text = kilasan
        binding.contentDetail.cpbUserScore.progress = user_score
    }

}