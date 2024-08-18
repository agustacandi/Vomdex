package dev.agustacandi.learn.vomdex.di

import dev.agustacandi.learn.core.domain.credits.usecase.CastInteractor
import dev.agustacandi.learn.core.domain.credits.usecase.CastUseCase
import dev.agustacandi.learn.core.domain.movie.usecase.MovieInteractor
import dev.agustacandi.learn.core.domain.movie.usecase.MovieUseCase
import dev.agustacandi.learn.vomdex.presentation.detail.DetailViewModel
import dev.agustacandi.learn.vomdex.presentation.home.HomeViewModel
import dev.agustacandi.learn.vomdex.presentation.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
    factory<CastUseCase> { CastInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { SearchViewModel(get()) }
    viewModel { DetailViewModel(get(), get(), get() )}
}