package com.ignaciocionchi.mymovies.mvp.view

import android.support.annotation.StringRes
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import com.ignaciocionchi.mymovies.R
import com.ignaciocionchi.mymovies.activity.HomeActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.app_bar_home.*

class HomeView(activity: HomeActivity) : ActivityView<HomeActivity>(activity) {

    private val toolbar = activity.toolbar
    private val drawerLayout = activity.drawer_layout
    private val navView = activity.nav_view

    fun int(listener: NavigationView.OnNavigationItemSelectedListener) {
        var activity = getActivity() ?: return

        activity.setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(
                activity, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(listener)

    }

    fun closeDrawer() {
        drawerLayout.closeDrawer(GravityCompat.START)
    }

    fun isDrawerOpen() = drawerLayout.isDrawerOpen(GravityCompat.START)


    fun onBackPressed() {
        var activity = getActivity() ?: return
        activity.onBackPressed()
    }

    fun setTitle(@StringRes string: Int) {
        var activity = getActivity() ?: return
        activity.setTitle(string)
    }

    fun includeFragment(fragment: Fragment) {
        var activity = getActivity() ?: return
        activity.supportFragmentManager.beginTransaction().replace(R.id.content_home, fragment).commit()
    }
}