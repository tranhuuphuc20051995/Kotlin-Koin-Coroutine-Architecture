package com.tranhuuphuc.kotlinkoincoroutinemvvm.databases.repositories

import com.tranhuuphuc.kotlinkoincoroutinemvvm.databases.AppDatabase
import com.tranhuuphuc.kotlinkoincoroutinemvvm.databases.models.Movie

class RepositoryManager(private val database: AppDatabase) : Repository.MovieRepository {
    override suspend fun insert(movie: Movie): Boolean {
        return database.movieDao().insert(movie) > 0
    }

    override suspend fun inserts(movie: List<Movie>) {
        database.movieDao().inserts(movie)
    }

    override suspend fun getMovies(): List<Movie> =
        database.movieDao().getMovies()

    override fun clear() {
        database.clearAllTables()
    }

}
