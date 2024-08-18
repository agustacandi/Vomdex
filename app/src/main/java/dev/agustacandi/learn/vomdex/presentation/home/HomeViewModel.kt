package dev.agustacandi.learn.vomdex.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dev.agustacandi.learn.core.domain.movie.usecase.MovieUseCase

class HomeViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val nowPlaying = movieUseCase.getNowPlaying().asLiveData()

    val popular = movieUseCase.getPopular().asLiveData()

    val topRated = movieUseCase.getTopRated().asLiveData()

    val upcoming = movieUseCase.getUpcoming().asLiveData()
}