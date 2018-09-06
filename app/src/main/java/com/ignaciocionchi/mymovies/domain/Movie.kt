package com.ignaciocionchi.mymovies.domain

data class Movie(
        val posterPath: String? = null,
        val adult: Boolean? = null,
        val overview: String? = null,
        val releaseDate: String? = null,
        val genreIds: List<Long>? = null,
        val id: Long? = null,
        val originalTitle: String? = null,
        val originalLanguage: String? = null,
        val title: String? = null,
        val backdropPath: String? = null,
        val popularity: Double? = null,
        val voteCount: Long? = null,
        val video: Boolean? = null,
        val voteAverage: Float? = null
)