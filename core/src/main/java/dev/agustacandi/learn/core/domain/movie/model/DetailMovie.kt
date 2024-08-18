package dev.agustacandi.learn.core.domain.movie.model

data class DetailMovie(

    val originalLanguage: String? = null,

    val imdbId: String? = null,

    val video: Boolean? = null,

    val title: String? = null,

    val backdropPath: String? = null,

    val revenue: Int? = null,

    val genres: List<Genres>? = null,

    val popularity: Double? = null,

    val productionCountries: List<ProductionCountries>? = null,

    val id: Int? = null,

    val voteCount: Int? = null,

    val budget: Int? = null,

    val overview: String? = null,

    val originalTitle: String? = null,

    val runtime: Int? = null,

    val posterPath: String? = null,

    val originCountry: List<String?>? = null,

    val spokenLanguages: List<SpokenLanguages>? = null,

    val productionCompanies: List<ProductionCompanies>? = null,

    val releaseDate: String? = null,

    val voteAverage: Double? = null,

    val belongsToCollection: BelongsToCollection? = null,

    val tagline: String? = null,

    val adult: Boolean? = null,

    val homepage: String? = null,

    val status: String? = null
)

data class ProductionCompanies(

    val logoPath: String? = null,

    val name: String? = null,

    val id: Int? = null,

    val originCountry: String? = null
)

data class BelongsToCollection(

    val backdropPath: String? = null,

    val name: String? = null,

    val id: Int? = null,

    val posterPath: String? = null
)

data class SpokenLanguages(

    val name: String? = null,

    val iso6391: String? = null,

    val englishName: String? = null
)

data class Genres(

    val name: String? = null,

    val id: Int? = null
)

data class ProductionCountries(

    val iso31661: String? = null,

    val name: String? = null
)

