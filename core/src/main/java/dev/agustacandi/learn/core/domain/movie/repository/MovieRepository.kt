package dev.agustacandi.learn.core.domain.movie.repository

import dev.agustacandi.learn.core.data.lib.RemoteResponse
import dev.agustacandi.learn.core.domain.movie.model.DetailMovie
import dev.agustacandi.learn.core.domain.movie.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getNowPlaying(): Flow<RemoteResponse<List<Movie>>>

    fun getPopular(): Flow<RemoteResponse<List<Movie>>>

    fun getTopRated(): Flow<RemoteResponse<List<Movie>>>

    fun getUpcoming(): Flow<RemoteResponse<List<Movie>>>

    fun searchMovie(query: String): Flow<RemoteResponse<List<Movie>>>

    fun getDetailMovie(movieId: String): Flow<RemoteResponse<DetailMovie>>
}