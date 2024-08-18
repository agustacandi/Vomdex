package dev.agustacandi.learn.core.data.favorite.local

import dev.agustacandi.learn.core.data.favorite.local.entity.MovieEntity
import dev.agustacandi.learn.core.data.favorite.local.room.MovieDao
import dev.agustacandi.learn.core.domain.favorite.repository.MovieFavoriteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MovieFavoriteRepositoryImpl(private val movieDao: MovieDao) : MovieFavoriteRepository {
    override suspend fun addFavorite(movie: MovieEntity) = movieDao.addFavorite(movie)

    override fun getAllFavorite(): Flow<List<MovieEntity>> = flow {
        val favorite = movieDao.getAllFavorite()
        emit(favorite)
    }

    override fun isFavorite(id: Int): Flow<Boolean> = flow {
        val favorite = movieDao.getFavorite(id)
        emit(favorite != null)
    }.flowOn(Dispatchers.IO)

    override suspend fun removeFavorite(id: Int) = movieDao.removeFavorite(id)
}