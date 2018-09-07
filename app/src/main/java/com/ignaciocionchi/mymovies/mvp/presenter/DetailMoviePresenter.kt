package com.ignaciocionchi.mymovies.mvp.presenter

import com.ignaciocionchi.mymovies.mvp.model.DetailMovieModel
import com.ignaciocionchi.mymovies.mvp.view.DetailMovieView
import io.reactivex.disposables.Disposable

class DetailMoviePresenter(val view: DetailMovieView, val model: DetailMovieModel) {
    private lateinit var disposable: Disposable

    init {
        view.init()
    }

    fun init() {
        view.showLoading()
        getDetailMovie()
    }

    private fun getDetailMovie() {
        disposable = model.getDetailMovieById()
                .subscribe(
                        { result ->
                            view.hideLoading()
                            view.displayMovie(result)
                            println("results: " + result)

                        },
                        { error ->
                            println(error.message)
                        })
    }

    fun dispose() {
        disposable.dispose()
    }


}