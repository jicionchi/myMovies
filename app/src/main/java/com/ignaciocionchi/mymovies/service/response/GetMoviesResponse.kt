package com.ignaciocionchi.mymovies.service.response

import com.squareup.moshi.Json

data class GetMoviesResponse(
        val page: Int,
        val results: List<MovieResponse>,
        @Json(name = "total_results") val totalResults: Long,
        @Json(name = "total_pages") val totalPages: Long,
        @Json(name = "status_message") val statusMessage: String,
        @Json(name = "status_code") val statusCode: Int
)
