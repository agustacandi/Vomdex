package dev.agustacandi.learn.core.data.movie.remote.response

import com.squareup.moshi.Json

data class DatesResponse(
    @Json(name = "maximum")
    val maximum: String? = null,

    @Json(name = "minimum")
    val minimum: String? = null
)
