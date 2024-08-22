package dev.agustacandi.learn.core.data.movie.remote.response

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class DatesResponse(
    @Json(name = "maximum")
    val maximum: String? = null,

    @Json(name = "minimum")
    val minimum: String? = null
)
