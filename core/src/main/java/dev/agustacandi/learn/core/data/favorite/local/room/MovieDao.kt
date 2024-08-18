package dev.agustacandi.learn.core.data.favorite.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.agustacandi.learn.core.data.favorite.local.entity.MovieEntity

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorite(story: MovieEntity)

    @Query("SELECT * FROM movie ORDER BY id DESC")
    suspend fun getAllFavorite(): List<MovieEntity>

    @Query("SELECT * FROM movie WHERE id = :id")
    fun getFavorite(id: Int): MovieEntity?

    @Query("DELETE FROM movie WHERE id = :id")
    suspend fun removeFavorite(id: Int)

}