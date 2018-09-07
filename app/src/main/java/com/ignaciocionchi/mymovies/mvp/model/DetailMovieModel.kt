package com.ignaciocionchi.mymovies.mvp.model

import com.ignaciocionchi.mymovies.service.MovieService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

class DetailMovieModel(val moveId: Long, val movieService: MovieService) {
    companion object {
        const val VIDEOS = "videos"
    }

    fun getDetailMovieById() = movieService.getDetailMovieById(Locale.getDefault().language, moveId, VIDEOS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())!!
}