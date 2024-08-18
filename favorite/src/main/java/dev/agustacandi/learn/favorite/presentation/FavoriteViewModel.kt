package dev.agustacandi.learn.favorite.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.agustacandi.learn.core.domain.favorite.mapper.toDomain
import dev.agustacandi.learn.core.domain.favorite.usecase.MovieFavoriteUseCase
import dev.agustacandi.learn.core.domain.movie.model.Movie
import kotlinx.coroutines.launch

class FavoriteViewModel(private val movieFavoriteUseCase: MovieFavoriteUseCase) : ViewModel() {
    private val _favorite = MutableLiveData<List<Movie>>()
    val favorite: LiveData<List<Movie>> = _favorite

    fun getFavoriteMovie() {
        viewModelScope.launch {
            movieFavoriteUseCase.getAllFavorite().collect {
                _favorite.value = it.toDomain()
            }
        }
    }

}