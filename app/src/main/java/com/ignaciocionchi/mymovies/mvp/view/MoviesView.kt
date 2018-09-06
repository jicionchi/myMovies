package com.ignaciocionchi.mymovies.mvp.view

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.ignaciocionchi.mymovies.R
import com.ignaciocionchi.mymovies.adapter.MoviesAdapter
import com.ignaciocionchi.mymovies.bus.RxBus
import com.ignaciocionchi.mymovies.bus.observer.LoadMoreMoviesBusOserver.LoadMoreMovies
import com.ignaciocionchi.mymovies.domain.Movie
import com.ignaciocionchi.mymovies.fragment.MoviesFragment

open class MoviesView(fragment: MoviesFragment) : FragmentView<MoviesFragment>(fragment) {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MoviesAdapter

    fun init() {
        val activity = getActivity() ?: return

        recyclerView = activity.findViewById<RecyclerView>(R.id.movies_recycler)!!
        val linearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        
        recyclerView.layoutManager = linearLayoutManager

        adapter = MoviesAdapter()
        recyclerView.adapter = adapter


        //pagination
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView?.canScrollVertically(1)!!) {
                    RxBus.post(LoadMoreMovies())
                }
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }
        })
    }

    fun addItems(items: List<Movie>) {
        adapter.addAll(items)
    }
}