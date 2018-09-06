package com.ignaciocionchi.mymovies.service

import com.ignaciocionchi.mymovies.BuildConfig.DEFAULT_LANG
import com.ignaciocionchi.mymovies.BuildConfig.DEFAULT_PAGE
import com.ignaciocionchi.mymovies.domain.DetailMovie
import com.ignaciocionchi.mymovies.domain.GetMovies
import io.reactivex.Observable

interface MovieService {

    fun getPopularMovies(language: String = DEFAULT_LANG, page: Int = DEFAULT_PAGE
    ): Observable<GetMovies>

    fun getTopRatedMovies(language: String = DEFAULT_LANG, page: Int = DEFAULT_PAGE
    ): Observable<GetMovies>

    fun getUpcomingMovies(language: String = DEFAULT_LANG, page: Int = DEFAULT_PAGE
    ): Observable<GetMovies>

    fun getDetailMovieById(language: String, moveId: Long, appendToResponse: String = ""
    ): Observable<DetailMovie>
}