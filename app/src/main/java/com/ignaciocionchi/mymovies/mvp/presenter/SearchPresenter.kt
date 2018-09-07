package com.ignaciocionchi.mymovies.mvp.presenter

import com.ignaciocionchi.mymovies.TypeOfMovieEnum
import com.ignaciocionchi.mymovies.activity.DetailMovieActivity
import com.ignaciocionchi.mymovies.bus.RxBus
import com.ignaciocionchi.mymovies.bus.observer.OnClickMovieBusOserver
import com.ignaciocionchi.mymovies.bus.observer.SearchBusOserver
import com.ignaciocionchi.mymovies.mvp.model.SearchModel
import com.ignaciocionchi.mymovies.mvp.view.SearchView

open class SearchPresenter(val view: SearchView, val model: SearchModel) {

    init {
        view.init()
    }

    fun subscribe() {
        RxBus.subscribe(this, object : SearchBusOserver() {
            override fun onEvent(value: Search) {
                view.clearAll()
                view.addItems(model.searchBy(view.getQuery(), view.typeSpinner.selectedItem as TypeOfMovieEnum))
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
}