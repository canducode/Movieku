package com.ngoopy.movieku.ui.tv_show

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ngoopy.movieku.R
import com.ngoopy.movieku.data.source.local.entity.ListTVShowsEntity
import com.ngoopy.movieku.databinding.ItemListBinding
import com.ngoopy.movieku.ui.detail.DetailActivity

class TVShowAdapter : PagedListAdapter<ListTVShowsEntity, TVShowAdapter.TVShowHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ListTVShowsEntity>() {
            override fun areItemsTheSame(
                oldItem: ListTVShowsEntity,
                newItem: ListTVShowsEntity
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: ListTVShowsEntity,
                newItem: ListTVShowsEntity
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    class TVShowHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvshow: ListTVShowsEntity) {
            with (binding) {
                tvTitle.text = tvshow.title
                tvDate.text = tvshow.first_release_date
                Glide.with(root.context)
                    .load(tvshow.poster_image)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(ivImage)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java).apply {
                        putExtra(DetailActivity.EXTRA_THEID, tvshow.id)
                        putExtra(DetailActivity.EXTRA_STATE, tvshow.bookmarked)
                    }
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowHolder {
        val viewBind = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TVShowHolder(viewBind)
    }

    override fun onBindViewHolder(holder: TVShowHolder, position: Int) {
        val tvshow = getItem(position)
        if (tvshow != null) {
            holder.bind(tvshow)
        }
    }
}