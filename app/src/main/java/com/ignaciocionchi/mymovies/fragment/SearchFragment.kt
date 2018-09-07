package com.ignaciocionchi.mymovies.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ignaciocionchi.mymovies.R
import com.ignaciocionchi.mymovies.mvp.model.SearchModel
import com.ignaciocionchi.mymovies.mvp.presenter.SearchPresenter
import com.ignaciocionchi.mymovies.mvp.view.SearchView
import com.ignaciocionchi.mymovies.repository.MovieRepositoryImpl

class SearchFragment() : Fragment() {

    companion object {
        fun newFragment(): Fragment = SearchFragment()
    }

    lateinit var presenter: SearchPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater?.inflate(R.layout.fragment_search, container, false);


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter = SearchPresenter(SearchView(this)
                , SearchModel(MovieRepositoryImpl()))
    }

    override fun onResume() {
        super.onResume()
        presenter.subscribe()
    }

    override fun onPause() {
        super.onPause()
        presenter.unsubscribe()
    }
}