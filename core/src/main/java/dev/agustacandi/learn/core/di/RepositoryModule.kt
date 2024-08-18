package dev.agustacandi.learn.core.di

import dev.agustacandi.learn.core.data.credits.remote.CastRepositoryImpl
import dev.agustacandi.learn.core.data.favorite.local.MovieFavoriteRepositoryImpl
import dev.agustacandi.learn.core.data.movie.remote.MovieRepositoryImpl
import dev.agustacandi.learn.core.domain.credits.repository.CastRepository
import dev.agustacandi.learn.core.domain.favorite.repository.MovieFavoriteRepository
import dev.agustacandi.learn.core.domain.favorite.usecase.MovieFavoriteInteractor
import dev.agustacandi.learn.core.domain.favorite.usecase.MovieFavoriteUseCase
import dev.agustacandi.learn.core.domain.movie.repository.MovieRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<MovieFavoriteUseCase> { MovieFavoriteInteractor(get()) }


    single<MovieRepository> { MovieRepositoryImpl(get()) }
    single<CastRepository> { CastRepositoryImpl(get()) }
    single<MovieFavoriteRepository> { MovieFavoriteRepositoryImpl(get()) }
}