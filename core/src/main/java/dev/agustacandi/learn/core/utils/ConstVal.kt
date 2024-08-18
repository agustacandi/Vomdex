package dev.agustacandi.learn.core.utils

import dev.agustacandi.learn.core.BuildConfig
import dev.agustacandi.learn.core.di.databaseModule
import dev.agustacandi.learn.core.di.networkModule
import dev.agustacandi.learn.core.di.repositoryModule

object ConstVal {

    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val IMAGE_URL = "https://image.tmdb.org/t/p"
    const val API_KEY = BuildConfig.API_KEY
    const val DATABASE_NAME = "movie.db"

    const val SPLASH_SCREEN_DURATION = 2000L

    // Koin Modules
    val coreModules = listOf(networkModule, repositoryModule, databaseModule)
}