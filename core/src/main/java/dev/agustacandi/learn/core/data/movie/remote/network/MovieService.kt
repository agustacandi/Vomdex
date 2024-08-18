package dev.agustacandi.learn.core.data.movie.remote.network

import dev.agustacandi.learn.core.data.movie.remote.response.DetailMovieResponse
import dev.agustacandi.learn.core.data.movie.remote.response.ListMovieResponse
import dev.agustacandi.learn.core.data.movie.remote.response.NowPlayingMovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    // Now Playing
    @GET("movie/now_playing")
    suspend fun getNowPlaying(
    ): NowPlayingMovieResponse

    // Popular
    @GET("movie/popular")
    suspend fun getPopular(
    ): ListMovieResponse

    // Top Rated
    @GET("movie/top_rated")
    suspend fun getTopRated(
    ): ListMovieResponse

    // Upcoming
    @GET("movie/upcoming")
    suspend fun getUpcoming(
    ): ListMovieResponse

    // Search Movie
    @GET("search/movie")
    suspend fun searchMovie(
        @Query("query") query: String
    ): ListMovieResponse

    // Detail Movie
    @GET("movie/{movieId}")
    suspend fun getDetailMovie(
        @Path("movieId") movieId: String
    ): DetailMovieResponse

}