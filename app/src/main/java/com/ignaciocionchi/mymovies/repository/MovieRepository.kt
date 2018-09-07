package com.ignaciocionchi.mymovies.repository

import com.ignaciocionchi.mymovies.TypeOfMovieEnum
import com.ignaciocionchi.mymovies.domain.Movie

interface MovieRepository {

    fun create(movies: List<Movie>, typeOfMovie: TypeOfMovieEnum)

    fun findBy(query: String, typeOfMovie: TypeOfMovieEnum): List<Movie>
}