package dev.agustacandi.learn.core.di

import androidx.room.Room.databaseBuilder
import dev.agustacandi.learn.core.utils.ConstVal
import dev.agustacandi.learn.core.data.favorite.local.room.MovieFavoriteDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        databaseBuilder(
            androidApplication(),
            MovieFavoriteDatabase::class.java,
            ConstVal.DATABASE_NAME
        ).build()
    }

    single { get<MovieFavoriteDatabase>().movieDao() }
}