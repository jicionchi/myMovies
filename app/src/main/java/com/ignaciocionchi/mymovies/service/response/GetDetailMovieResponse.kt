package com.ignaciocionchi.mymovies.service.response

import com.squareup.moshi.Json

data class GetDetailMovieResponse(
        @Json(name = "poster_path") val posterPath: String?,
        val adult: Boolean,
        val overview: String,
        @Json(name = "release_date") val releaseDate: String,
        @Json(name = "genres") val genres: List<GenreResponse>,
        val id: Long,
        @Json(name = "original_title") val originalTitle: String,
        @Json(name = "original_language") val originalLanguage: String,
        val title: String,
        val homepage: String?,
        @Json(name = "backdrop_path") val backdropPath: String?,
        val popularity: Double,
        @Json(name = "vote_count") val voteCount: Long,
        val videos: VideosResponse,
        @Json(name = "vote_average") val voteAverage: Float,
        @Json(name = "production_companies") val productionCompanies: List<ProductionCompaniesResponse>,
        val revenue: Long,
        val status: String,
        val tagline: String,
        @Json(name = "status_message") val statusMessage: String?,
        @Json(name = "status_code") val statusCode: Int?
)