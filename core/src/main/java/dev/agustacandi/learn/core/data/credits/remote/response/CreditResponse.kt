package dev.agustacandi.learn.core.data.credits.remote.response

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class CreditResponse(

	@Json(name="cast")
	val cast: List<CastItem>? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="crew")
	val crew: List<CrewItem>? = null
)

@Keep
data class CrewItem(

	@Json(name="gender")
	val gender: Int? = null,

	@Json(name="credit_id")
	val creditId: String? = null,

	@Json(name="known_for_department")
	val knownForDepartment: String? = null,

	@Json(name="original_name")
	val originalName: String? = null,

	@Json(name="popularity")
	val popularity: Double? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="profile_path")
	val profilePath: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="adult")
	val adult: Boolean? = null,

	@Json(name="department")
	val department: String? = null,

	@Json(name="job")
	val job: String? = null
)

@Keep
data class CastItem(

	@Json(name="cast_id")
	val castId: Int? = null,

	@Json(name="character")
	val character: String? = null,

	@Json(name="gender")
	val gender: Int? = null,

	@Json(name="credit_id")
	val creditId: String? = null,

	@Json(name="known_for_department")
	val knownForDepartment: String? = null,

	@Json(name="original_name")
	val originalName: String? = null,

	@Json(name="popularity")
	val popularity: Double? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="profile_path")
	val profilePath: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="adult")
	val adult: Boolean? = null,

	@Json(name="order")
	val order: Int? = null
)
