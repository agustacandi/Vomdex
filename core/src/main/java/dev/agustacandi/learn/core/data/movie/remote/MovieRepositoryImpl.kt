package dev.agustacandi.learn.core.data.movie.remote

import dev.agustacandi.learn.core.data.lib.RemoteResponse
import dev.agustacandi.learn.core.data.movie.remote.network.MovieService
import dev.agustacandi.learn.core.domain.movie.mapper.toDomain
import dev.agustacandi.learn.core.domain.movie.model.DetailMovie
import dev.agustacandi.learn.core.domain.movie.model.Movie
import dev.agustacandi.learn.core.domain.movie.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MovieRepositoryImpl(private val movieService: MovieService) : MovieRepository {
    override fun getNowPlaying(): Flow<RemoteResponse<List<Movie>>> = flow {
        try {
            emit(RemoteResponse.Loading)
            val response = movieService.getNowPlaying()
            val data = response.results?.toDomain()
            if (data.isNullOrEmpty()) {
                emit(RemoteResponse.Empty)
            } else {
                emit(RemoteResponse.Success(data))
            }
        } catch (e: Exception) {
            emit(RemoteResponse.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    override fun getPopular(): Flow<RemoteResponse<List<Movie>>> = flow {
        try {
            emit(RemoteResponse.Loading)
            val response = movieService.getPopular()
            val data = response.results?.toDomain()
            if (data.isNullOrEmpty()) {
                emit(RemoteResponse.Empty)
            } else {
                emit(RemoteResponse.Success(data))
            }
        } catch (e: Exception) {
            emit(RemoteResponse.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    override fun getTopRated(): Flow<RemoteResponse<List<Movie>>> = flow {
        try {
            emit(RemoteResponse.Loading)
            val response = movieService.getTopRated()
            val data = response.results?.toDomain()
            if (data.isNullOrEmpty()) {
                emit(RemoteResponse.Empty)
            } else {
                emit(RemoteResponse.Success(data))
            }
        } catch (e: Exception) {
            emit(RemoteResponse.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    override fun getUpcoming(): Flow<RemoteResponse<List<Movie>>> = flow {
        try {
            emit(RemoteResponse.Loading)
            val response = movieService.getUpcoming()
            val data = response.results?.toDomain()
            if (data.isNullOrEmpty()) {
                emit(RemoteResponse.Empty)
            } else {
                emit(RemoteResponse.Success(data))
            }
        } catch (e: Exception) {
            emit(RemoteResponse.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    override fun searchMovie(query: String): Flow<RemoteResponse<List<Movie>>> = flow {
        try {
            emit(RemoteResponse.Loading)
            val response = movieService.searchMovie(query)
            val data = response.results?.toDomain()
            if (data.isNullOrEmpty()) {
                emit(RemoteResponse.Empty)
            } else {
                emit(RemoteResponse.Success(data))
            }
        } catch (e: Exception) {
            emit(RemoteResponse.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    override fun getDetailMovie(movieId: String): Flow<RemoteResponse<DetailMovie>> = flow {
            try {
                emit(RemoteResponse.Loading)
                val response = movieService.getDetailMovie(movieId)
                val data = response.toDomain()
                emit(RemoteResponse.Success(data))
            } catch (e: Exception) {
                emit(RemoteResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
}