package com.tranhuuphuc.kotlinkoincoroutinemvvm.databases.repositories

import com.tranhuuphuc.kotlinkoincoroutinemvvm.models.Movie

interface Repository {
    fun clear()

    interface MovieRepository : Repository {
        suspend fun getMovies(): List<Movie>
        suspend fun insert(movie: Movie): Boolean
        suspend fun inserts(movie: List<Movie>)
    }
}
