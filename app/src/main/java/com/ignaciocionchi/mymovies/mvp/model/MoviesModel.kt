package com.ignaciocionchi.mymovies.mvp.model

import com.ignaciocionchi.mymovies.BuildConfig
import com.ignaciocionchi.mymovies.TypeOfMovieEnum
import com.ignaciocionchi.mymovies.service.MovieService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

open class MoviesModel(val type: String, val movieService: MovieService) {

    var page: Int = BuildConfig.DEFAULT_PAGE

    fun getPopularMovies(page: Int) = movieService.getPopularMovies(Locale.getDefault().language, page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())!!

    fun getTopMovies(page: Int) = movieService.getTopRatedMovies(Locale.getDefault().language, page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())!!

    fun getUpcomingMovies(page: Int) = movieService.getUpcomingMovies(Locale.getDefault().language, page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())!!


    fun getType() = TypeOfMovieEnum.valueOf(type)
}