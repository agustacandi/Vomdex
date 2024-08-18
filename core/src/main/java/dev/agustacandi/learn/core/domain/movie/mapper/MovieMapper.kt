package dev.agustacandi.learn.core.domain.movie.mapper

import dev.agustacandi.learn.core.data.movie.remote.response.DetailMovieResponse
import dev.agustacandi.learn.core.data.movie.remote.response.GenresItem
import dev.agustacandi.learn.core.data.movie.remote.response.MovieItem
import dev.agustacandi.learn.core.data.movie.remote.response.ProductionCompaniesItem
import dev.agustacandi.learn.core.data.movie.remote.response.ProductionCountriesItem
import dev.agustacandi.learn.core.data.movie.remote.response.SpokenLanguagesItem
import dev.agustacandi.learn.core.domain.movie.model.DetailMovie
import dev.agustacandi.learn.core.domain.movie.model.Genres
import dev.agustacandi.learn.core.domain.movie.model.Movie
import dev.agustacandi.learn.core.domain.movie.model.ProductionCompanies
import dev.agustacandi.learn.core.domain.movie.model.ProductionCountries
import dev.agustacandi.learn.core.domain.movie.model.SpokenLanguages

fun List<MovieItem>.toDomain(): List<Movie> {
    return this.map {
        Movie(
            overview = it.overview ?: "",
            originalLanguage = it.originalLanguage ?: "",
            originalTitle = it.originalTitle ?: "",
            video = it.video ?: false,
            title = it.title ?: "",
            genreIds = it.genreIds ?: listOf(),
            posterPath = it.posterPath ?: "",
            backdropPath = it.backdropPath ?: "",
            releaseDate = it.releaseDate ?: "",
            popularity = it.popularity ?: 0.0,
            voteAverage = it.voteAverage ?: 0.0,
            id = it.id ?: 0,
            adult = it.adult ?: false,
            voteCount = it.voteCount ?: 0
        )
    }
}

fun DetailMovieResponse.toDomain(): DetailMovie {
    return DetailMovie(
        originalLanguage = this.originalLanguage ?: "",
        imdbId = this.imdbId ?: "",
        video = this.video ?: false,
        title = this.title ?: "",
        backdropPath = this.backdropPath ?: "",
        revenue = this.revenue ?: 0,
        genres = this.genres?.toDomain() ?: listOf(),
        popularity = this.popularity ?: 0.0,
        productionCountries = this.productionCountries?.toDomain() ?: listOf(),
        id = this.id ?: 0,
        voteCount = this.voteCount ?: 0,
        budget = this.budget ?: 0,
        overview = this.overview ?: "",
        originalTitle = this.originalTitle ?: "",
        runtime = this.runtime ?: 0,
        posterPath = this.posterPath ?: "",
        originCountry = this.originCountry ?: listOf(),
        spokenLanguages = this.spokenLanguages?.toDomain() ?: listOf(),
        productionCompanies = this.productionCompanies?.toDomain() ?: listOf(),
        releaseDate = this.releaseDate ?: "",
        voteAverage = this.voteAverage ?: 0.0
    )
}