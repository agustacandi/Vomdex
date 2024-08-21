package dev.agustacandi.learn.core.di

import androidx.room.Room.databaseBuilder
import dev.agustacandi.learn.core.utils.ConstVal
import dev.agustacandi.learn.core.data.favorite.local.room.MovieFavoriteDatabase
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        val passphrase: ByteArray = SQLiteDatabase.getBytes(ConstVal.PASSPHRASE_DB.toCharArray())
        val factory = SupportFactory(passphrase)

        databaseBuilder(
            androidApplication(),
            MovieFavoriteDatabase::class.java,
            ConstVal.DATABASE_NAME
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }

    single { get<MovieFavoriteDatabase>().movieDao() }
}