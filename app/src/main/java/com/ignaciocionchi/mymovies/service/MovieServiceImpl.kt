package com.ignaciocionchi.mymovies.service

import com.ignaciocionchi.mymovies.BuildConfig
import com.ignaciocionchi.mymovies.domain.DetailMovie
import com.ignaciocionchi.mymovies.domain.GetMovies
import com.ignaciocionchi.mymovies.mapper.MovieMapper
import io.reactivex.Observable

class MovieServiceImpl : MovieService {

    override fun getPopularMovies(language: String, page: Int): Observable<GetMovies> {
        return ServiceUtils.movieApi
                .getPopularMovies(BuildConfig.API_KEY, language, page)
                .map({ t ->
                    MovieMapper.transform(t)!!
                })
    }

    override fun getTopRatedMovies(language: String, page: Int): Observable<GetMovies> {
        return ServiceUtils.movieApi
                .getTopRatedMovies(BuildConfig.API_KEY, language, page)
                .map({ t ->
                    MovieMapper.transform(t)!!
                })
    }

    override fun getUpcomingMovies(language: String, page: Int): Observable<GetMovies> {
        return ServiceUtils.movieApi
                .getUpcomingMovies(BuildConfig.API_KEY, language, page)
                .map({ t ->
                    MovieMapper.transform(t)!!
                })
    }

    override fun getDetailMovieById(language: String, moveId: Long, appendToResponse: String): Observable<DetailMovie> {
        return ServiceUtils.movieApi
                .getDetailMovieById(moveId, BuildConfig.API_KEY, language, appendToResponse)
                .map({ t ->
                    MovieMapper.transform(t)!!
                })
    }
}

