package com.ignaciocionchi.mymovies.domain

data class GetMovies(
        val page: Int,
        val results: List<Movie>,
        val totalResults: Long,
        val totalPages: Long,
        val statusMessage: String?,
        val statusCode: Int
)