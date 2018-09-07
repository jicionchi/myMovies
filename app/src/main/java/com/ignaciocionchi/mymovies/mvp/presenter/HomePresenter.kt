package com.ignaciocionchi.mymovies.mvp.presenter

import android.support.design.widget.NavigationView
import android.view.MenuItem
import com.ignaciocionchi.mymovies.R
import com.ignaciocionchi.mymovies.TypeOfMovieEnum
import com.ignaciocionchi.mymovies.fragment.MoviesFragment
import com.ignaciocionchi.mymovies.fragment.SearchFragment
import com.ignaciocionchi.mymovies.mvp.model.HomeModel
import com.ignaciocionchi.mymovies.mvp.view.HomeView

open class HomePresenter(val view: HomeView, val model: HomeModel) {

    init {
        view.int(object : NavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                return innerNavigationItemSelected(item)
            }
        })
        view.setTitle(R.string.nav_search)
        view.includeFragment(SearchFragment.newFragment())
    }

    private fun innerNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_search -> {
                view.setTitle(R.string.nav_search)
                view.includeFragment(SearchFragment.newFragment())
            }
            R.id.nav_top -> {
                view.setTitle(R.string.nav_top)
                view.includeFragment(MoviesFragment.newFragment(TypeOfMovieEnum.TOP))
            }
            R.id.nav_popular -> {
                view.setTitle(R.string.nav_popular)
                view.includeFragment(MoviesFragment.newFragment(TypeOfMovieEnum.POPULAR))

            }
            R.id.nav_upcoming -> {
                view.setTitle(R.string.nav_upcoming)
                view.includeFragment(MoviesFragment.newFragment(TypeOfMovieEnum.UPCOMING))
            }
        }

        view.closeDrawer()
        return true
    }

    fun onBackPressed() {
        if (view.isDrawerOpen()) {
            view.closeDrawer()
        } else {
            view.onBackPressed()
        }

    }

}