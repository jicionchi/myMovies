package com.ignaciocionchi.mymovies.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ignaciocionchi.mymovies.BuildConfig
import com.ignaciocionchi.mymovies.R
import com.ignaciocionchi.mymovies.bus.RxBus
import com.ignaciocionchi.mymovies.bus.observer.OnClickMovieBusOserver
import com.ignaciocionchi.mymovies.domain.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_move_list.view.*

open class MoviesAdapter() : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {
    companion object {
        const val LOADING_VIEW_TYPE = 1
        const val MOVIE_VIEW_TYPE = 2
    }

    var items = ArrayList<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MovieViewHolder =
            MovieViewHolder(LayoutInflater.from(parent?.context).inflate(
                    if (viewType == MOVIE_VIEW_TYPE) R.layout.item_move_list else R.layout.item_loading
                    , parent, false))

    override fun onBindViewHolder(holder: MovieViewHolder?, position: Int) {
        if (getItemViewType(position) == LOADING_VIEW_TYPE) {
            return
        }

        holder?.bind(items.get(position))
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position].id == null) LOADING_VIEW_TYPE else MOVIE_VIEW_TYPE
    }

    override fun getItemCount() = items.size


    fun addAll(newItems: List<Movie>) {
        if (items.isNotEmpty() && getItemViewType(items.size - 1) == LOADING_VIEW_TYPE) {
            items.removeAt(items.size - 1)
            notifyItemRemoved(items.size - 1)
        }
        if (newItems.isNotEmpty()) {
            items.addAll(newItems)
            items.add(Movie())
            notifyItemInserted(items.size - 1)
        }
    }


    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val date = view.item_date
        val title = view.item_title
        val image = view.item_image
        val layout = view.item_layout
        fun bind(item: Movie) {
            title?.text = item.title
            date?.text = item.releaseDate
            layout.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    RxBus.post(OnClickMovieBusOserver.OnClickMovie(item.id!!))
                }
            })
            Picasso.get().load("${BuildConfig.API_BASE_URL_IMAGE}${item.posterPath}")
                    .placeholder(R.drawable.image_placeholder)
                    .into(image)
        }
    }

}