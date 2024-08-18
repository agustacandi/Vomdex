package dev.agustacandi.learn.core.domain.credits.mapper

import dev.agustacandi.learn.core.data.credits.remote.response.CastItem
import dev.agustacandi.learn.core.domain.credits.model.Cast

fun List<CastItem>.toDomain(): List<Cast> {
    return this.map {
        Cast(
            castId = it.castId ?: 0,
            character = it.character ?: "",
            gender = it.gender ?: 0,
            creditId = it.creditId ?: "",
            knownForDepartment = it.knownForDepartment ?: "",
            originalName = it.originalName ?: "",
            popularity = it.popularity ?: 0.0,
            name = it.name ?: "",
            profilePath = it.profilePath ?: "",
            id = it.id ?: 0,
            adult = it.adult ?: false,
            order = it.order ?: 0
        )
    }
}

fun CastItem.toDomain(): Cast {
    return Cast(
        castId = this.castId ?: 0,
        character = this.character ?: "",
        gender = this.gender ?: 0,
        creditId = this.creditId ?: "",
        knownForDepartment = this.knownForDepartment ?: "",
        originalName = this.originalName ?: "",
        popularity = this.popularity ?: 0.0,
        name = this.name ?: "",
        profilePath = this.profilePath ?: "",
        id = this.id ?: 0,
        adult = this.adult ?: false,
        order = this.order ?: 0
    )
}