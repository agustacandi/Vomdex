package dev.agustacandi.learn.core.domain.movie.usecase

import dev.agustacandi.learn.core.domain.movie.repository.MovieRepository

class MovieInteractor(private val movieRepository: MovieRepository) : MovieUseCase {
    override fun getNowPlaying() = movieRepository.getNowPlaying()

    override fun getPopular() = movieRepository.getPopular()

    override fun getTopRated() = movieRepository.getTopRated()

    override fun getUpcoming() = movieRepository.getUpcoming()

    override fun searchMovie(query: String) = movieRepository.searchMovie(query)

    override fun getDetailMovie(movieId: String) = movieRepository.getDetailMovie(movieId)
}