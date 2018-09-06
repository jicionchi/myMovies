package com.ignaciocionchi.mymovies.service.response

import com.squareup.moshi.Json

data class MovieResponse(
        @Json(name = "poster_path") val posterPath: String,
        val adult: Boolean,
        val overview: String,
        @Json(name = "release_date") val releaseDate: String,
        @Json(name = "genre_ids") val genreIds: List<Long>,
        val id: Long,
        @Json(name = "original_title") val originalTitle: String,
        @Json(name = "original_language") val originalLanguage: String,
        val title: String,
        @Json(name = "backdrop_path") val backdropPath: String,
        val popularity: Double,
        @Json(name = "vote_count") val voteCount: Long,
        @Json(name = "video") val video: Boolean,
        @Json(name = "vote_average") val voteAverage: Float
)