package com.tranhuuphuc.kotlinkoincoroutinemvvm.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tranhuuphuc.kotlinkoincoroutinemvvm.databases.converters.MovieConverter
import com.tranhuuphuc.kotlinkoincoroutinemvvm.databases.dao.MovieDao
import com.tranhuuphuc.kotlinkoincoroutinemvvm.models.Movie

/**
 * Created by TranHuuPhuc on 2019-08-02.
 */
@Database(
    entities = [Movie::class], version = 1
    , exportSchema = false
)
@TypeConverters(MovieConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}