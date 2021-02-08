package com.ngoopy.movieku.ui.tv_show

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ngoopy.movieku.R
import com.ngoopy.movieku.data.entity.ListTVShowsEntity
import com.ngoopy.movieku.databinding.ItemListBinding
import com.ngoopy.movieku.ui.detail.DetailActivity

class TVShowAdapter : RecyclerView.Adapter<TVShowAdapter.TVShowHolder>() {
    private var listTVShow = ArrayList<ListTVShowsEntity>()

    fun setTVShows(tvshows: List<ListTVShowsEntity>?) {
        if (tvshows == null) return
        listTVShow.clear()
        listTVShow.addAll(tvshows)
    }

    class TVShowHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvshow: ListTVShowsEntity) {
            with (binding) {
                tvTitle.text = tvshow.title
                tvDate.text = tvshow.first_release_data
                Glide.with(root.context)
                    .load(tvshow.poster_image)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(ivImage)

                root.setOnClickListener {
                    @Suppress("DEPRECATION") val intentGoToDetail = Intent(root.context, DetailActivity::class.java).apply {
                        putExtra(DetailActivity.EXTRA_THEID, tvshow.id)
                    }
                    root.context.startActivity(intentGoToDetail)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowHolder {
        val viewBind = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TVShowHolder(viewBind)
    }

    override fun onBindViewHolder(holder: TVShowHolder, position: Int) {
        holder.bind(listTVShow[position])
    }

    override fun getItemCount() = listTVShow.size
}