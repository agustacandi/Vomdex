package dev.agustacandi.learn.core.utils

import dev.agustacandi.learn.core.BuildConfig
import dev.agustacandi.learn.core.di.databaseModule
import dev.agustacandi.learn.core.di.networkModule
import dev.agustacandi.learn.core.di.repositoryModule

object ConstVal {
    const val HOSTNAME = BuildConfig.HOSTNAME
    const val PIN_CERT = BuildConfig.PIN_CERT
    const val PIN_CERT_2 = BuildConfig.PIN_CERT_2
    const val PIN_CERT_3 = BuildConfig.PIN_CERT_3
    const val PASSPHRASE_DB = BuildConfig.PASSPHRASE_DB
    const val BASE_URL = BuildConfig.BASE_URL
    const val IMAGE_URL = "https://image.tmdb.org/t/p"
    const val API_KEY = BuildConfig.API_KEY
    const val DATABASE_NAME = "movie.db"

    const val SPLASH_SCREEN_DURATION = 2000L

    const val KEY_MOVIE_ID = "movieId"

    // Koin Modules
    val coreModules = listOf(networkModule, repositoryModule, databaseModule)
}