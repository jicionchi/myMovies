package com.ignaciocionchi.mymovies.manager

import com.ignaciocionchi.mymovies.BuildConfig
import com.ignaciocionchi.mymovies.TypeOfMovieEnum
import com.ignaciocionchi.mymovies.repository.MovieRepository
import com.ignaciocionchi.mymovies.repository.MovieRepositoryImpl
import com.ignaciocionchi.mymovies.service.MovieService
import com.ignaciocionchi.mymovies.service.MovieServiceImpl
import io.reactivex.schedulers.Schedulers
import java.util.*

object DownloadMoviesManager {
    private const val INVALID_PAGE = -1
    private var movieService: MovieService = MovieServiceImpl()
    private var movieRepository: MovieRepository = MovieRepositoryImpl()

    fun downloadPopularMovies(page: Int = BuildConfig.DEFAULT_PAGE) {
        if (page != INVALID_PAGE) {
            movieService.getPopularMovies(Locale.getDefault().language, page)
                    .subscribeOn(Schedulers.computation())
                    .observeOn(Schedulers.computation())
                    .subscribe(
                            { result ->
                                if (result?.results?.isEmpty()!!) {
                                    downloadPopularMovies(INVALID_PAGE)
                                } else {
                                    movieRepository.create(result.results, TypeOfMovieEnum.POPULAR)
                                    downloadPopularMovies(page + 1)
                                }
                            },
                            { error ->
                                downloadPopularMovies(INVALID_PAGE)
                            })
        }
    }

    fun downloadTopRacedMovies(page: Int = BuildConfig.DEFAULT_PAGE) {
        if (page != INVALID_PAGE) {
            movieService.getPopularMovies(Locale.getDefault().language, page)
                    .subscribeOn(Schedulers.computation())
                    .observeOn(Schedulers.computation())
                    .subscribe(
                            { result ->
                                if (result?.results?.isEmpty()!!) {
                                    downloadPopularMovies(INVALID_PAGE)
                                } else {
                                    movieRepository.create(result.results, TypeOfMovieEnum.TOP)
                                    downloadPopularMovies(page + 1)
                                }
                            },
                            { error ->
                                downloadPopularMovies(INVALID_PAGE)
                            })
        }
    }

    fun downloadUpcomingMovies(page: Int = BuildConfig.DEFAULT_PAGE) {

        if (page != INVALID_PAGE) {
            movieService.getPopularMovies(Locale.getDefault().language, page)
                    .subscribeOn(Schedulers.computation())
                    .observeOn(Schedulers.computation())
                    .subscribe(
                            { result ->
                                if (result?.results?.isEmpty()!!) {
                                    downloadPopularMovies(INVALID_PAGE)
                                } else {
                                    movieRepository.create(result.results, TypeOfMovieEnum.UPCOMING)
                                    downloadPopularMovies(page + 1)
                                }
                            },
                            { error ->
                                downloadPopularMovies(INVALID_PAGE)
                            })
        }
    }
}