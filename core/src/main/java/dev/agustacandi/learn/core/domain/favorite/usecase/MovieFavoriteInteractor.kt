package dev.agustacandi.learn.core.domain.favorite.usecase

import dev.agustacandi.learn.core.domain.favorite.repository.MovieFavoriteRepository
import dev.agustacandi.learn.core.domain.movie.model.Movie
import kotlinx.coroutines.flow.Flow

class MovieFavoriteInteractor(private val movieFavoriteRepository: MovieFavoriteRepository) :
    MovieFavoriteUseCase {
    override suspend fun addFavorite(movie: Movie) = movieFavoriteRepository.addFavorite(movie)

    override fun getAllFavorite(): Flow<List<Movie>> = movieFavoriteRepository.getAllFavorite()

    override fun isFavorite(id: Int): Flow<Boolean> = movieFavoriteRepository.isFavorite(id)

    override suspend fun removeFavorite(id: Int) = movieFavoriteRepository.removeFavorite(id)

    override suspend fun removeAllFavorite() = movieFavoriteRepository.removeAllFavorite()
}