package com.ignaciocionchi.mymovies.mvp.model

import com.ignaciocionchi.mymovies.TypeOfMovieEnum
import com.ignaciocionchi.mymovies.repository.MovieRepository

class SearchModel(val movieRepository: MovieRepository) {
    fun searchBy(query: String, typeOfMovie: TypeOfMovieEnum) = movieRepository.findBy(query, typeOfMovie)
}