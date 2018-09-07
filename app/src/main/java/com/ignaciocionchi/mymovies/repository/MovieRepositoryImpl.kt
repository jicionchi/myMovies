package com.ignaciocionchi.mymovies.repository

import com.ignaciocionchi.mymovies.TypeOfMovieEnum
import com.ignaciocionchi.mymovies.domain.Movie
import com.ignaciocionchi.mymovies.mapper.MovieMapper
import com.ignaciocionchi.mymovies.repository.entity.MovieEntity
import io.realm.Realm

class MovieRepositoryImpl() : MovieRepository {

    override fun create(movies: List<Movie>, typeOfMovie: TypeOfMovieEnum) {
        var entities = MovieMapper.transformEntities(movies)
        for (entity in entities) {
            entity.typeOfMovie = typeOfMovie.name
            create(entity)
        }
    }

    private fun create(entity: MovieEntity) {
        var realm = Realm.getDefaultInstance()
        realm.executeTransaction { realm ->
            realm.copyToRealmOrUpdate(entity);
        }
    }

    override fun findBy(query: String, typeOfMovie: TypeOfMovieEnum): List<Movie> {
        var result = Realm.getDefaultInstance().where(MovieEntity::class.java)
                .equalTo(MovieEntity.TYPE_OF_MOVIE, typeOfMovie.name)
                .contains(MovieEntity.TITLE, query)
                .findAll()
        return MovieMapper.transformEntities(result)
    }
}