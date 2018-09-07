package com.ignaciocionchi.mymovies

import android.app.Application
import com.ignaciocionchi.mymovies.manager.DownloadMoviesManager
import io.realm.Realm
import io.realm.RealmConfiguration

class MoviesApp() : Application() {


    companion object {
        lateinit var instance: MoviesApp
            private set
    }


    override fun onCreate() {
        super.onCreate()
        instance = this

        initRealm()
        initDownloadMovies()
    }

    private fun initDownloadMovies() {
        DownloadMoviesManager.downloadPopularMovies()
        DownloadMoviesManager.downloadTopRacedMovies()
        DownloadMoviesManager.downloadUpcomingMovies()
    }

    private fun initRealm() {
        var configuration = RealmConfiguration.Builder(this)
                .name(BuildConfig.BD_NAME)
                .deleteRealmIfMigrationNeeded()
        Realm.setDefaultConfiguration(configuration.build())

    }

}