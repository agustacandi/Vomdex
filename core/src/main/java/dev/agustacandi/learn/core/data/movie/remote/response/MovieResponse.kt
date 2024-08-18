package dev.agustacandi.learn.core.data.movie.remote.response

import com.squareup.moshi.Json

abstract class BaseMovieResponse(
	@Json(name="page")
	val page: Int? = null,

	@Json(name="total_pages")
	val totalPages: Int? = null,

	@Json(name="total_results")
	val totalResults: Int? = null
)

data class ListMovieResponse(
	@Json(name="results")
	val results: List<MovieItem>? = null,
) : BaseMovieResponse()

data class NowPlayingMovieResponse(
	@Json(name="dates")
	val dates: DatesResponse? = null,

	@Json(name="results")
	val results: List<MovieItem>? = null,
)


