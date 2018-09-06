package com.ignaciocionchi.mymovies.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ignaciocionchi.mymovies.R
import com.ignaciocionchi.mymovies.TypeOfMovieEnum
import com.ignaciocionchi.mymovies.mvp.model.MoviesModel
import com.ignaciocionchi.mymovies.mvp.presenter.MoviesPresenter
import com.ignaciocionchi.mymovies.mvp.view.MoviesView
import com.ignaciocionchi.mymovies.service.MovieServiceImpl

open class MoviesFragment() : android.support.v4.app.Fragment() {

    companion object {
        const val TYPE_MOVIE = "MoviesFragment.typeMovie"
        fun newFragment(type: TypeOfMovieEnum): Fragment {
            val fragment = MoviesFragment()
            val bundle = Bundle()
            bundle.putString(TYPE_MOVIE, type.name)
            fragment.arguments = bundle
            return fragment
        }
    }

    lateinit var presenter: MoviesPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater?.inflate(R.layout.fragment_movies, container, false);


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter = MoviesPresenter(MoviesView(this)
                , MoviesModel(arguments.getString(TYPE_MOVIE), MovieServiceImpl()))
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