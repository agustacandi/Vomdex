package dev.agustacandi.learn.core.domain.movie.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val overview: String? = null,

    val originalLanguage: String? = null,

    val originalTitle: String? = null,

    val video: Boolean? = null,

    val title: String? = null,

    val genreIds: List<Int>? = null,

    val posterPath: String? = null,

    val backdropPath: String? = null,

    val releaseDate: String? = null,

    val popularity: Double? = null,

    val voteAverage: Double? = null,

    val id: Int? = null,

    val adult: Boolean? = null,

    val voteCount: Int? = null
) : Parcelable
