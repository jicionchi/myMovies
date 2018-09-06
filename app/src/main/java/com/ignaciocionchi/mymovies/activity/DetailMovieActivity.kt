package com.ignaciocionchi.mymovies.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.ignaciocionchi.mymovies.R
import com.ignaciocionchi.mymovies.mvp.model.DetailMovieModel
import com.ignaciocionchi.mymovies.mvp.presenter.DetailMoviePresenter
import com.ignaciocionchi.mymovies.mvp.view.DetailMovieView
import com.ignaciocionchi.mymovies.service.MovieServiceImpl

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val INTENT_MOVE_ID = "INTENT_MOVE_ID"
        fun newIntent(moveId: Long, activity: Activity) =
                Intent(activity, DetailMovieActivity::class.java)
                        .putExtra(INTENT_MOVE_ID, moveId)
    }

    lateinit var presenter: DetailMoviePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        presenter = DetailMoviePresenter(DetailMovieView(this)
                , DetailMovieModel(intent?.getLongExtra(INTENT_MOVE_ID, 0)!!, MovieServiceImpl()))
        presenter.init()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        onBackPressed()
        return true
    }

    override fun onResume() {
        super.onResume()
        presenter.init()
    }

    override fun onPause() {
        super.onPause()
        presenter.dispose()
    }
}
