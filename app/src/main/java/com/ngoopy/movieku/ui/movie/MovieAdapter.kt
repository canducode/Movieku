package com.ngoopy.movieku.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ngoopy.movieku.R
import com.ngoopy.movieku.data.source.local.entity.ListMoviesEntity
import com.ngoopy.movieku.databinding.ItemListBinding
import com.ngoopy.movieku.ui.detail.DetailActivity

class MovieAdapter : PagedListAdapter<ListMoviesEntity, MovieAdapter.MovieHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ListMoviesEntity>() {
            override fun areItemsTheSame(oldItem: ListMoviesEntity, newItem: ListMoviesEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ListMoviesEntity, newItem: ListMoviesEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val viewBind = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieHolder(viewBind)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie)
        }
    }

    inner class MovieHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: ListMoviesEntity) {
            with(binding) {
                tvTitle.text = movies.title
                tvDate.text = movies.release_date
                Glide.with(root.context)
                        .load(movies.poster_image)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                        .into(ivImage)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java).apply {
                        putExtra(DetailActivity.EXTRA_TYPE, "Movie")
                        putExtra(DetailActivity.EXTRA_THEID, movies.id)
                        putExtra(DetailActivity.EXTRA_STATE, movies.bookmarked)
                    }
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}