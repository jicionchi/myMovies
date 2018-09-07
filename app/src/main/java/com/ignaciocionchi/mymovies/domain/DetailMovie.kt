package com.ignaciocionchi.mymovies.domain

data class DetailMovie(
        val posterPath: String?,
        val adult: Boolean,
        val overview: String,
        val releaseDate: String,
        val genres: List<Genre>,
        val id: Long,
        val originalTitle: String,
        val originalLanguage: String,
        val title: String,
        val backdropPath: String?,
        val popularity: Double,
        val voteCount: Long,
        val videos: List<Video>,
        val voteAverage: Float,
        val homepage: String?,
        val productionCompanies: List<ProductionCompanies>,
        val revenue: Long,
        val status: String,
        val tagline: String,
        val statusMessage: String?,
        val statusCode: Int?
)