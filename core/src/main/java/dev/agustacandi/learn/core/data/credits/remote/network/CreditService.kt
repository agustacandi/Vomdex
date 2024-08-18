package dev.agustacandi.learn.core.data.credits.remote.network

import dev.agustacandi.learn.core.data.credits.remote.response.CreditResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CreditService {
    @GET("movie/{movie_id}/credits")
    suspend fun getCredits(
        @Path("movie_id") movieId: String
    ): CreditResponse
}