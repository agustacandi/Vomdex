package dev.agustacandi.learn.vomdex.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.agustacandi.learn.core.data.lib.RemoteResponse
import dev.agustacandi.learn.core.domain.movie.model.Movie
import dev.agustacandi.learn.core.domain.movie.usecase.MovieUseCase
import kotlinx.coroutines.launch

class SearchViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {

    private val _searchResult = MutableLiveData<RemoteResponse<List<Movie>>>()
    val searchResult: LiveData<RemoteResponse<List<Movie>>> = _searchResult

    fun searchMovie(query: String) {
        viewModelScope.launch {
            movieUseCase.searchMovie(query).collect {
                _searchResult.value = it
            }
        }
    }
}