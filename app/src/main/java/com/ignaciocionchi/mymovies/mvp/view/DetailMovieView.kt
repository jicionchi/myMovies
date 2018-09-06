package com.ignaciocionchi.mymovies.mvp.view

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerFragment
import com.ignaciocionchi.mymovies.BuildConfig
import com.ignaciocionchi.mymovies.R
import com.ignaciocionchi.mymovies.activity.DetailMovieActivity
import com.ignaciocionchi.mymovies.domain.DetailMovie
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import kotlinx.android.synthetic.main.activity_detail_movie.*
import kotlinx.android.synthetic.main.content_detail_movie.*
import java.lang.Exception

open class DetailMovieView(activity: DetailMovieActivity) : ActivityView<DetailMovieActivity>(activity) {

    private var titleTextView: TextView = activity.detail_title
    private var overviewTextView: TextView = activity.detail_overview
    private var image: ImageView = activity.detail_image
    private var genres: TextView = activity.detail_genres
    private var loadingView: View = activity.detail_loading

    fun init() {
        val activity = getActivity() ?: return
        activity.setSupportActionBar(activity.detail_toolbar)
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    fun hideLoading() {
        loadingView.visibility = View.GONE
    }

    fun showLoading() {
        loadingView.visibility = View.VISIBLE
    }

    fun displayMovie(detail: DetailMovie) {
        val title = if (detail.title.isNullOrEmpty()) detail.originalTitle else detail.title
        titleTextView.text = title
        overviewTextView.text = detail.overview
        var builder = StringBuilder()
        for (genre in detail.genres) {
            builder.append(genre.name)
            builder.append(SEPARATOR)
        }
        genres.text = builder

        getActivity()?.setTitle(title)


        Picasso.get().load("${BuildConfig.API_BASE_URL_IMAGE}${detail.posterPath}")
                .placeholder(R.drawable.image_placeholder)
                .into(image)

        Picasso.get().load("${BuildConfig.API_BASE_URL_IMAGE}${detail.backdropPath}")
                .placeholder(R.drawable.image_placeholder)
                .into(object : Target {
                    override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
                    }

                    override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                    }

                    override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                        getActivity()?.toolbar_layout?.background = BitmapDrawable(getActivity()?.resources, bitmap)
                    }

                })



        if (detail.videos.isEmpty()) {
            return
        }
        addYoutubePlayer(detail.videos[0].key)

    }

    private fun addYoutubePlayer(key: String) {
        val youtubeFragment: YouTubePlayerFragment = YouTubePlayerFragment.newInstance()
        youtubeFragment.retainInstance = true

        getActivity()?.fragmentManager?.beginTransaction()?.replace(R.id.item_video, youtubeFragment)?.commit()
        youtubeFragment.initialize(BuildConfig.API_YOUTUBE_KEY, object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(provider: YouTubePlayer.Provider?, youTubePlayer: YouTubePlayer?, b: Boolean) {
                youTubePlayer?.cueVideo(key);

            }

            override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
            }
        })
    }


    companion object {
        const val SEPARATOR = " "
    }


}