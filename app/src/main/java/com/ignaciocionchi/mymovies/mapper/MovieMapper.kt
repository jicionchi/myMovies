package com.ignaciocionchi.mymovies.mapper

import com.ignaciocionchi.mymovies.domain.*
import com.ignaciocionchi.mymovies.repository.entity.MovieEntity
import com.ignaciocionchi.mymovies.service.response.*
import io.realm.RealmResults

object MovieMapper {

    fun transform(response: GetMoviesResponse): GetMovies {
        var getMovies = GetMovies(response.page,
                transform(response.results),
                response.totalResults,
                response.totalPages,
                response.statusMessage,
                response.statusCode)

        return getMovies
    }

    private fun transform(moviesResponse: List<MovieResponse>): List<Movie> {
        var listOfMovies = mutableListOf<Movie>()
        for (movieResponse in moviesResponse) {
            var movie = Movie(movieResponse.posterPath,
                    movieResponse.adult,
                    movieResponse.overview,
                    movieResponse.releaseDate,
                    movieResponse.genreIds,
                    movieResponse.id,
                    movieResponse.originalTitle,
                    movieResponse.originalLanguage,
                    movieResponse.title,
                    movieResponse.backdropPath,
                    movieResponse.popularity,
                    movieResponse.voteCount,
                    movieResponse.video,
                    movieResponse.voteAverage
            )

            listOfMovies.add(movie)

        }
        return listOfMovies
    }

    fun transform(response: GetDetailMovieResponse): DetailMovie {
        var movie = DetailMovie(response.posterPath,
                response.adult,
                response.overview,
                response.releaseDate,
                transformGenres(response.genres),
                response.id,
                response.originalTitle,
                response.originalLanguage,
                response.title,
                response.backdropPath,
                response.popularity,
                response.voteCount,
                transformVideos(response.videos),
                response.voteAverage,
                response.homepage,
                transformProductCompanies(response.productionCompanies),
                response.revenue,
                response.status,
                response.tagline,
                response.statusMessage,
                response.statusCode

        )

        return movie
    }

    private fun transformProductCompanies(listOfResponse: List<ProductionCompaniesResponse>): List<ProductionCompanies> {
        var listOfProductionCompanies = mutableListOf<ProductionCompanies>()
        for (response in listOfResponse) {
            var productionCompanies = ProductionCompanies(response.id,
                    response.logoPath,
                    response.name,
                    response.originCountry
            )

            listOfProductionCompanies.add(productionCompanies)

        }
        return listOfProductionCompanies
    }

    private fun transformGenres(listOfResponse: List<GenreResponse>): List<Genre> {
        var listOfGenre = mutableListOf<Genre>()
        for (response in listOfResponse) {
            var genre = Genre(response.id,
                    response.name
            )

            listOfGenre.add(genre)

        }
        return listOfGenre
    }

    private fun transformVideos(reponse: VideosResponse): List<Video> {
        var listOfVideo = mutableListOf<Video>()
        for (videoResponse in reponse.results) {
            var video = Video(videoResponse.id,
                    videoResponse.iso6391,
                    videoResponse.iso31661,
                    videoResponse.key,
                    videoResponse.name,
                    videoResponse.site,
                    videoResponse.size,
                    videoResponse.type
            )
            listOfVideo.add(video)

        }
        return listOfVideo
    }


    fun transformEntities(movies: List<Movie>): List<MovieEntity> {
        var listOfMovies = mutableListOf<MovieEntity>()
        for (movie in movies) {
            var movieEntity = MovieEntity(movie.posterPath,
                    movie.adult,
                    movie.overview,
                    movie.releaseDate,
//                    movie.genreIds,
                    movie.id,
                    movie.originalTitle,
                    movie.originalLanguage,
                    movie.title,
                    movie.backdropPath,
                    movie.popularity,
                    movie.voteCount,
                    movie.video,
                    movie.voteAverage
            )

            listOfMovies.add(movieEntity)

        }
        return listOfMovies
    }

    fun transformEntities(movies: RealmResults<MovieEntity>): List<Movie> {
        var listOfMovies = mutableListOf<Movie>()
        for (movieEntity in movies) {
            var movie = Movie(movieEntity.posterPath,
                    movieEntity.adult,
                    movieEntity.overview,
                    movieEntity.releaseDate,
                    null,
                    movieEntity.id,
                    movieEntity.originalTitle,
                    movieEntity.originalLanguage,
                    movieEntity.title,
                    movieEntity.backdropPath,
                    movieEntity.popularity,
                    movieEntity.voteCount,
                    movieEntity.video,
                    movieEntity.voteAverage
            )

            listOfMovies.add(movie)

        }
        return listOfMovies
    }
}