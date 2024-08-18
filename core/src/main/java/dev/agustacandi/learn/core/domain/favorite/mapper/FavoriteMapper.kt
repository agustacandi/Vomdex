package dev.agustacandi.learn.core.domain.favorite.mapper

import dev.agustacandi.learn.core.data.favorite.local.entity.MovieEntity
import dev.agustacandi.learn.core.domain.movie.model.Movie

fun MovieEntity.toDomain(): Movie {
    return Movie(
        overview = this.overview,
        originalLanguage = this.originalLanguage,
        originalTitle = this.originalTitle,
        video = this.video,
        title = this.title,
        posterPath = this.posterPath,
        backdropPath = this.backdropPath,
        releaseDate = this.releaseDate,
        popularity = this.popularity,
        voteAverage = this.voteAverage,
        id = this.id,
        adult = this.adult,
        voteCount = this.voteCount
    )
}

fun List<MovieEntity>.toDomain(): List<Movie> {
    return this.map {
        Movie(
            overview = it.overview,
            originalLanguage = it.originalLanguage,
            originalTitle = it.originalTitle,
            video = it.video,
            title = it.title,
            posterPath = it.posterPath,
            backdropPath = it.backdropPath,
            releaseDate = it.releaseDate,
            popularity = it.popularity,
            voteAverage = it.voteAverage,
            id = it.id,
            adult = it.adult,
            voteCount = it.voteCount
        )
    }
}