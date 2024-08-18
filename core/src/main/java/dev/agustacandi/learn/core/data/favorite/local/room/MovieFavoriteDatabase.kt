package dev.agustacandi.learn.core.data.favorite.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.agustacandi.learn.core.data.favorite.local.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class MovieFavoriteDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}