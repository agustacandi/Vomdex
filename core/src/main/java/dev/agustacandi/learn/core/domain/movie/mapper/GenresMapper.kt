package dev.agustacandi.learn.core.domain.movie.mapper

import dev.agustacandi.learn.core.data.movie.remote.response.GenresItem
import dev.agustacandi.learn.core.domain.movie.model.Genres

fun List<GenresItem>.toDomain(): List<Genres> {
    return this.map {
        Genres(
            name = it.name ?: "",
            id = it.id ?: 0
        )
    }
}