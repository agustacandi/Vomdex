package dev.agustacandi.learn.core.data.credits.remote

import dev.agustacandi.learn.core.data.credits.remote.network.CreditService
import dev.agustacandi.learn.core.data.lib.RemoteResponse
import dev.agustacandi.learn.core.domain.credits.mapper.toDomain
import dev.agustacandi.learn.core.domain.credits.model.Cast
import dev.agustacandi.learn.core.domain.credits.repository.CastRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CastRepositoryImpl(private val creditService: CreditService) : CastRepository {
    override fun getCast(movieId: String): Flow<RemoteResponse<List<Cast>>> = flow {
        try {
            emit(RemoteResponse.Loading)
            val response = creditService.getCredits(movieId)
            val data = response.cast?.toDomain()
            if (data.isNullOrEmpty()) {
                emit(RemoteResponse.Empty)
            } else {
                emit(RemoteResponse.Success(data))
            }
        } catch (e: Exception) {
            emit(RemoteResponse.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)
}