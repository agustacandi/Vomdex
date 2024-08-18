package dev.agustacandi.learn.vomdex.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.agustacandi.learn.core.data.favorite.local.entity.MovieEntity
import dev.agustacandi.learn.core.data.lib.RemoteResponse
import dev.agustacandi.learn.core.domain.credits.model.Cast
import dev.agustacandi.learn.core.domain.credits.usecase.CastUseCase
import dev.agustacandi.learn.core.domain.favorite.usecase.MovieFavoriteUseCase
import dev.agustacandi.learn.core.domain.movie.model.DetailMovie
import dev.agustacandi.learn.core.domain.movie.usecase.MovieUseCase
import kotlinx.coroutines.launch

class DetailViewModel(
    private val castUseCase: CastUseCase,
    private val movieUseCase: MovieUseCase,
    private val movieFavoriteUseCase: MovieFavoriteUseCase
) : ViewModel() {
    private val _castResult = MutableLiveData<RemoteResponse<List<Cast>>>()
    val castResult: LiveData<RemoteResponse<List<Cast>>> = _castResult

    private val _detailMovieResult = MutableLiveData<RemoteResponse<DetailMovie>>()
    val detailMovieResult: LiveData<RemoteResponse<DetailMovie>> = _detailMovieResult

    private val _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean> = _isFavorite

    fun getCast(movieId: String) {
        viewModelScope.launch {
            castUseCase.getCast(movieId).collect {
                _castResult.value = it
            }
        }
    }

    fun getDetailMovie(movieId: String) {
        viewModelScope.launch {
            movieUseCase.getDetailMovie(movieId).collect {
                _detailMovieResult.value = it
            }
        }
    }

    fun checkFavorite(movieId: String) {
        viewModelScope.launch {
            movieFavoriteUseCase.isFavorite(movieId.toInt()).collect {
                _isFavorite.value = it
            }
        }
    }

    fun addFavorite(movie: MovieEntity) {
        viewModelScope.launch {
            movieFavoriteUseCase.addFavorite(movie)
            _isFavorite.value = true
        }
    }

    fun removeFavorite(movieId: String) {
        viewModelScope.launch {
            movieFavoriteUseCase.removeFavorite(movieId.toInt())
            _isFavorite.value = false
        }
    }
}