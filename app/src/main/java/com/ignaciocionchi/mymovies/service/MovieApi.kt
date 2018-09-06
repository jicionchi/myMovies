package com.ignaciocionchi.mymovies.service

import com.ignaciocionchi.mymovies.service.response.GetDetailMovieResponse
import com.ignaciocionchi.mymovies.service.response.GetMoviesResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String,
                         @Query("language") language: String,
                         @Query("page") page: Int
    ): Observable<GetMoviesResponse>

    @GET("movie/top_rated")
    fun getTopRatedMovies(@Query("api_key") apiKey: String,
                          @Query("language") language: String,
                          @Query("page") page: Int
    ): Observable<GetMoviesResponse>

    @GET("movie/upcoming")
    fun getUpcomingMovies(@Query("api_key") apiKey: String,
                          @Query("language") language: String,
                          @Query("page") page: Int
    ): Observable<GetMoviesResponse>


    @GET("movie/{movie_id}")
    fun getDetailMovieById(@Path("movie_id") page: Long,
                           @Query("api_key") apiKey: String,
                           @Query("language") language: String,
                           @Query("append_to_response") appendToResponse: String
    ): Observable<GetDetailMovieResponse>

}