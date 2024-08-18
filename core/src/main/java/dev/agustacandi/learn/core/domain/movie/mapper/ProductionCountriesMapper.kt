package dev.agustacandi.learn.core.domain.movie.mapper

import dev.agustacandi.learn.core.data.movie.remote.response.ProductionCountriesItem
import dev.agustacandi.learn.core.domain.movie.model.ProductionCountries

fun List<ProductionCountriesItem>.toDomain(): List<ProductionCountries> {
    return this.map {
        ProductionCountries(
            iso31661 = it.iso31661 ?: "",
            name = it.name ?: ""
        )
    }
}