package dev.agustacandi.learn.core.domain.credits.usecase

import dev.agustacandi.learn.core.domain.credits.repository.CastRepository

class CastInteractor(private val castRepository: CastRepository) : CastUseCase  {
    override fun getCast(movieId: String) = castRepository.getCast(movieId)
}