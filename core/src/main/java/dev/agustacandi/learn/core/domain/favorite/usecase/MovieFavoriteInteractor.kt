package dev.agustacandi.learn.core.domain.favorite.usecase

import dev.agustacandi.learn.core.data.favorite.local.entity.MovieEntity
import dev.agustacandi.learn.core.domain.favorite.repository.MovieFavoriteRepository
import kotlinx.coroutines.flow.Flow

class MovieFavoriteInteractor(private val movieFavoriteRepository: MovieFavoriteRepository) :
    MovieFavoriteUseCase {
    override suspend fun addFavorite(movie: MovieEntity) = movieFavoriteRepository.addFavorite(movie)

    override fun getAllFavorite(): Flow<List<MovieEntity>> = movieFavoriteRepository.getAllFavorite()

    override fun isFavorite(id: Int): Flow<Boolean> = movieFavoriteRepository.isFavorite(id)

    override suspend fun removeFavorite(id: Int) = movieFavoriteRepository.removeFavorite(id)
}