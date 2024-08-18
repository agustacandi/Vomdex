package dev.agustacandi.learn.core.domain.movie.mapper

import dev.agustacandi.learn.core.data.movie.remote.response.SpokenLanguagesItem
import dev.agustacandi.learn.core.domain.movie.model.SpokenLanguages

fun List<SpokenLanguagesItem>.toDomain(): List<SpokenLanguages> {
    return this.map {
        SpokenLanguages(
            name = it.name ?: "",
            iso6391 = it.iso6391 ?: "",
            englishName = it.englishName ?: ""
        )
    }
}