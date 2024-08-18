package dev.agustacandi.learn.core.domain.favorite.repository

import dev.agustacandi.learn.core.data.favorite.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

interface MovieFavoriteRepository {
    suspend fun addFavorite(movie: MovieEntity)
    fun getAllFavorite(): Flow<List<MovieEntity>>
    fun isFavorite(id: Int): Flow<Boolean>
    suspend fun removeFavorite(id: Int)
}