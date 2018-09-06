package com.ignaciocionchi.mymovies.mvp.presenter

import com.ignaciocionchi.mymovies.BuildConfig
import com.ignaciocionchi.mymovies.TypeOfMovieEnum
import com.ignaciocionchi.mymovies.activity.DetailMovieActivity
import com.ignaciocionchi.mymovies.bus.RxBus
import com.ignaciocionchi.mymovies.bus.observer.LoadMoreMoviesBusOserver
import com.ignaciocionchi.mymovies.bus.observer.OnClickMovieBusOserver
import com.ignaciocionchi.mymovies.mvp.model.MoviesModel
import com.ignaciocionchi.mymovies.mvp.view.MoviesView

open class MoviesPresenter(val view: MoviesView, val model: MoviesModel) {


    init {
        view.init()
        getMovies(BuildConfig.DEFAULT_PAGE)
    }


    fun subscribe() {
        RxBus.subscribe(this, object : LoadMoreMoviesBusOserver() {
            override fun onEvent(value: LoadMoreMovies) {
                getMoreMovies()
            }
        })
        RxBus.subscribe(this, object : OnClickMovieBusOserver() {
            override fun onEvent(value: OnClickMovie) {
                goToDetailActivity(value.moveId)
            }
        })
    }

    fun unsubscribe() {
        RxBus.clear(this)
    }

    private fun goToDetailActivity(moveId: Long) {
        val activity = view.getActivity() ?: return
        val intent = DetailMovieActivity.newIntent(moveId, activity)
        activity.startActivity(intent);
    }

    private fun getMoreMovies() {
        getMovies(model.page + 1)

    }

    private fun getMovies(page: Int) {
        model.page = page
        when (model.getType()) {
            TypeOfMovieEnum.POPULAR ->
                getPopularMovies(model.page)
            TypeOfMovieEnum.TOP ->
                getTopMovies(model.page)
            TypeOfMovieEnum.UPCOMING ->
                getUpcomingMovies(model.page)
        }
    }

    private fun getPopularMovies(page: Int) {
        model.getPopularMovies(page)
                .subscribe(
                        { result ->
                            view.addItems(result.results)
                            println("page: " + result.page)
                            println("results: " + result.results)
                            println("statusCode: " + result.statusCode)
                            println("statusMessage: " + result.statusMessage)

                        },
                        { error ->
                            view.addItems(ArrayList())
                            println(error.message)
                        })

    }

    private fun getTopMovies(page: Int) {
        model.getTopMovies(page)
                .subscribe(
                        { result ->
                            view.addItems(result.results)
                            println("page: " + result.page)
                            println("results: " + result.results)
                            println("statusCode: " + result.statusCode)
                            println("statusMessage: " + result.statusMessage)

                        },
                        { error ->
                            view.addItems(ArrayList())
                            println(error.message)
                        })

    }

    private fun getUpcomingMovies(page: Int) {
        model.getUpcomingMovies(page)
                .subscribe(
                        { result ->
                            view.addItems(result.results)
                            println("page: " + result.page)
                            println("results: " + result.results)
                            println("statusCode: " + result.statusCode)
                            println("statusMessage: " + result.statusMessage)

                        },
                        { error ->
                            view.addItems(ArrayList())
                            println(error.message)
                        })

    }

}