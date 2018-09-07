package com.ignaciocionchi.mymovies.repository.entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class MovieEntity(
        var posterPath: String? = null,
        var adult: Boolean? = null,
        var overview: String? = null,
        var releaseDate: String? = null,
        @PrimaryKey var id: Long? = null,
        var originalTitle: String? = null,
        var originalLanguage: String? = null,
        var title: String? = null,
        var backdropPath: String? = null,
        var popularity: Double? = null,
        var voteCount: Long? = null,
        var video: Boolean? = null,
        var voteAverage: Float? = null,
        //category
        var typeOfMovie: String? = null
) : RealmObject() {

    companion object {
        const val ID = "id"
        const val TYPE_OF_MOVIE = "typeOfMovie"
        const val TITLE = "title"
    }
}


