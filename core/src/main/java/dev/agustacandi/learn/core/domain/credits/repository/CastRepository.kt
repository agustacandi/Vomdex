package dev.agustacandi.learn.core.domain.credits.repository

import dev.agustacandi.learn.core.data.lib.RemoteResponse
import dev.agustacandi.learn.core.domain.credits.model.Cast
import kotlinx.coroutines.flow.Flow

interface CastRepository {
    fun getCast(movieId: String): Flow<RemoteResponse<List<Cast>>>
}