package dev.agustacandi.learn.core.domain.favorite.mapper

import dev.agustacandi.learn.core.data.favorite.local.entity.MovieEntity
import dev.agustacandi.learn.core.domain.movie.model.Movie

fun Movie.toData(): MovieEntity {
    return MovieEntity(
        overview = this.overview ?: "",
        originalLanguage = this.originalLanguage ?: "",
        originalTitle = this.originalTitle ?: "",
        video = this.video ?: false,
        title = this.title ?: "",
        posterPath = this.posterPath ?: "",
        backdropPath = this.backdropPath ?: "",
        releaseDate = this.releaseDate ?: "",
        popularity = this.popularity ?: 0.0,
        voteAverage = this.voteAverage ?: 0.0,
        id = this.id ?: 0,
        adult = this.adult ?: false,
        voteCount = this.voteCount ?: 0
    )
}