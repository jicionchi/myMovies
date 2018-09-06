package com.ignaciocionchi.mymovies.activity

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.ignaciocionchi.mymovies.R
import com.ignaciocionchi.mymovies.TypeOfMovieEnum
import com.ignaciocionchi.mymovies.fragment.MoviesFragment
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_home.*

open class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_search -> {
                setTitle(R.string.nav_search)
            }
            R.id.nav_top -> {
                setTitle(R.string.nav_top)
                supportFragmentManager.beginTransaction().replace(R.id.content_home, MoviesFragment.newFragment(TypeOfMovieEnum.TOP)).commit()
            }
            R.id.nav_popular -> {
                setTitle(R.string.nav_popular)
                supportFragmentManager.beginTransaction().replace(R.id.content_home, MoviesFragment.newFragment(TypeOfMovieEnum.POPULAR)).commit()
            }
            R.id.nav_upcoming -> {
                setTitle(R.string.nav_upcoming)
                supportFragmentManager.beginTransaction().replace(R.id.content_home, MoviesFragment.newFragment(TypeOfMovieEnum.UPCOMING)).commit()
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
