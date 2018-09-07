package com.ignaciocionchi.mymovies.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ignaciocionchi.mymovies.R
import com.ignaciocionchi.mymovies.mvp.model.HomeModel
import com.ignaciocionchi.mymovies.mvp.presenter.HomePresenter
import com.ignaciocionchi.mymovies.mvp.view.HomeView

class HomeActivity : AppCompatActivity() {
    lateinit var presenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        presenter = HomePresenter(HomeView(this), HomeModel())
    }

    override fun onBackPressed() {
        presenter.onBackPressed()
    }
}
