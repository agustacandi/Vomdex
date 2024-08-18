package dev.agustacandi.learn.core.domain.movie.mapper

import dev.agustacandi.learn.core.data.movie.remote.response.ProductionCompaniesItem
import dev.agustacandi.learn.core.domain.movie.model.ProductionCompanies

fun List<ProductionCompaniesItem>.toDomain(): List<ProductionCompanies> {
    return this.map {
        ProductionCompanies(
            logoPath = it.logoPath ?: "",
            name = it.name ?: "",
            id = it.id ?: 0,
            originCountry = it.originCountry ?: ""
        )
    }
}