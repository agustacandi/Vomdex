package dev.agustacandi.learn.core.domain.favorite.repository

import dev.agustacandi.learn.core.domain.movie.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieFavoriteRepository {
    suspend fun addFavorite(movie: Movie)
    fun getAllFavorite(): Flow<List<Movie>>
    fun isFavorite(id: Int): Flow<Boolean>
    suspend fun removeFavorite(id: Int)
    suspend fun removeAllFavorite()
}