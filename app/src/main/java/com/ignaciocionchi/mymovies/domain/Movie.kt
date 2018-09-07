package com.ignaciocionchi.mymovies.domain

data class Movie(
        var posterPath: String? = null,
        var adult: Boolean? = null,
        var overview: String? = null,
        var releaseDate: String? = null,
        var genreIds: List<Long>? = null,
        var id: Long? = null,
        var originalTitle: String? = null,
        var originalLanguage: String? = null,
        var title: String? = null,
        var backdropPath: String? = null,
        var popularity: Double? = null,
        var voteCount: Long? = null,
        var video: Boolean? = null,
        var voteAverage: Float? = null
)