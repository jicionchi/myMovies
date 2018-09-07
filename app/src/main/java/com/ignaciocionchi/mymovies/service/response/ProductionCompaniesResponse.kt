package com.ignaciocionchi.mymovies.service.response

import com.squareup.moshi.Json

data class ProductionCompaniesResponse(val id: Int,
                                       @Json(name = "logo_path") val logoPath: String?,
                                       val name: String,
                                       @Json(name = "origin_country") val originCountry: String)

