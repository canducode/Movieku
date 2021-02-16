package com.ngoopy.movieku.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ngoopy.movieku.R
import com.ngoopy.movieku.data.source.local.entity.ListMoviesEntity
import com.ngoopy.movieku.databinding.ItemListBinding
import com.ngoopy.movieku.ui.detail.DetailActivity

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieHolder>() {
    private var listMovies = ArrayList<ListMoviesEntity>()

    fun setMovies(movies: List<ListMoviesEntity>?) {
        if (movies == null) return
        listMovies.clear()
        listMovies.addAll(movies)
    }

    class MovieHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: ListMoviesEntity) {
            with(binding) {
                tvTitle.text = movies.title
                tvDate.text = movies.release_date
                Glide.with(root.context)
                    .load(movies.poster_image)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(ivImage)

                binding.root.setOnClickListener {
                    @Suppress("DEPRECATION") val intentGoToDetail = Intent(root.context, DetailActivity::class.java).apply {
                        putExtra(DetailActivity.EXTRA_TYPE, "Movie")
                        putExtra(DetailActivity.EXTRA_THEID, movies.id)
                    }
                    root.context.startActivity(intentGoToDetail)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val viewBind = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieHolder(viewBind)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(listMovies[position])
    }

    override fun getItemCount() = listMovies.size
}