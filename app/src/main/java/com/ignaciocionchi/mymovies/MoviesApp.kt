package com.ignaciocionchi.mymovies

import android.app.Application

open class MoviesApp() : Application() {


    companion object {
        lateinit var instance: MoviesApp
            private set
    }


    override fun onCreate() {
        super.onCreate()
        instance = this

    }

}