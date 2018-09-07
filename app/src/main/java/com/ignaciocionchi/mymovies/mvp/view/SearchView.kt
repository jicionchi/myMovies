package com.ignaciocionchi.mymovies.mvp.view

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import com.ignaciocionchi.mymovies.R
import com.ignaciocionchi.mymovies.TypeOfMovieEnum
import com.ignaciocionchi.mymovies.adapter.MoviesAdapter
import com.ignaciocionchi.mymovies.bus.RxBus
import com.ignaciocionchi.mymovies.bus.observer.SearchBusOserver
import com.ignaciocionchi.mymovies.domain.Movie
import com.ignaciocionchi.mymovies.fragment.SearchFragment

open class SearchView(fragment: SearchFragment) : FragmentView<SearchFragment>(fragment) {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MoviesAdapter
    private lateinit var queryTextView: EditText
    lateinit var typeSpinner: Spinner


    fun init() {
        val activity = getActivity() ?: return
        activity.findViewById<Button>(R.id.search_button).setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                RxBus.post(SearchBusOserver.Search())
            }

        })
        typeSpinner = activity.findViewById(R.id.search_type)
        initSpinner()

        queryTextView = activity.findViewById(R.id.search_query)
        recyclerView = activity.findViewById<RecyclerView>(R.id.movies_recycler)!!
        val linearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = linearLayoutManager
        adapter = MoviesAdapter(false)
        recyclerView.adapter = adapter

    }

    private fun initSpinner() {
        val activity = getActivity() ?: return

        val adapter = ArrayAdapter(activity, android.R.layout.simple_spinner_item, TypeOfMovieEnum.values())
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        typeSpinner.adapter = adapter;
    }

    fun getQuery() = queryTextView.text.toString()
    fun addItems(items: List<Movie>) {
        adapter.addAll(items)
    }

    fun clearAll() {
        adapter.clearAll()
    }
}