package com.tranhuuphuc.kotlinkoincoroutinemvvm.databases.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tranhuuphuc.kotlinkoincoroutinemvvm.databases.models.Movie

/**
 * Created by TranHuuPhuc on 2019-08-02.
 */
@Dao
interface MovieDao {
    @Query("SELECT * FROM movie")
    suspend fun getMovies(): List<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie: Movie): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserts(movie: List<Movie>)
}