package dev.agustacandi.learn.core.domain.credits.usecase

import dev.agustacandi.learn.core.data.lib.RemoteResponse
import dev.agustacandi.learn.core.domain.credits.model.Cast
import kotlinx.coroutines.flow.Flow

interface CastUseCase {
    fun getCast(movieId: String): Flow<RemoteResponse<List<Cast>>>
}