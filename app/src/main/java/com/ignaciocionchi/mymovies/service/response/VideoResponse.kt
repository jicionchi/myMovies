package com.ignaciocionchi.mymovies.service.response

import com.squareup.moshi.Json

data class VideoResponse(val id: String,
                         @Json(name = "iso_639_1") val iso6391: String,
                         @Json(name = "iso_3166_1") val iso31661: String,
                         val key: String,
                         val name: String,
                         val site: String,
                         val size: Int,
                         val type: String
)