package com.tranhuuphuc.kotlinkoincoroutinemvvm.managers.movie

import com.google.gson.Gson
import com.tranhuuphuc.kotlinkoincoroutinemvvm.databases.repositories.RepositoryManager
import com.tranhuuphuc.kotlinkoincoroutinemvvm.databases.models.Movie
import com.tranhuuphuc.kotlinkoincoroutinemvvm.networks.interactors.MovieInteractor
import com.tranhuuphuc.kotlinkoincoroutinemvvm.utils.ErrorResponse
import com.tranhuuphuc.kotlinkoincoroutinemvvm.managers.network.NetworkManager
import com.tranhuuphuc.kotlinkoincoroutinemvvm.utils.Resource
import com.tranhuuphuc.kotlinkoincoroutinemvvm.utils.toObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

/**
 * Created by TranHuuPhuc on 2019-08-02.
 */
class MovieManagerImpl(
    private val moveInteractor: MovieInteractor,
    private val networkManager: NetworkManager,
    private val repositoryManager: RepositoryManager,
    private val gson: Gson
) : MovieManager {
    override suspend fun getMovieFavorite(): Resource<List<Movie>> = withContext(Dispatchers.IO) {
        val movieFavorites = repositoryManager.getMovies()
        Resource.Success(movieFavorites)
    }

    override suspend fun addMovieFavorite(movie: Movie): Resource<Boolean> = withContext(Dispatchers.IO) {
        if (repositoryManager.insert(movie)) {
            Resource.Success(true)
        } else {
            Resource.Error(
                IOException(""),
                networkManager.isConnected
            )
        }
    }

    override suspend fun getNowPlaying(page: Int) = withContext(Dispatchers.IO) {
        val response = moveInteractor.getNowPlaying(page)
        if (response?.isSuccessful == true) {
            Resource.Success(response.body()!!)
        } else {
            Resource.Error(
                IOException(response?.errorBody().toObject<ErrorResponse>(gson)?.message),
                networkManager.isConnected
            )
        }
    }

    override suspend fun searchMovies(query: String, page: Int) = withContext(Dispatchers.IO) {
        val response = moveInteractor.searchMovies(query, page)
        if (response?.isSuccessful == true) {
            Resource.Success(response.body()!!)
        } else {
            Resource.Error(
                IOException(response?.errorBody().toObject<ErrorResponse>(gson)?.message),
                networkManager.isConnected
            )
        }
    }

    override suspend fun getVideoTrailer(movieId: Int) = withContext(Dispatchers.IO) {
        val response = moveInteractor.getVideoTrailer(movieId)
        if (response?.isSuccessful == true) {
            Resource.Success(response.body()!!)
        } else {
            Resource.Error(
                IOException(response?.errorBody().toObject<ErrorResponse>(gson)?.message),
                networkManager.isConnected
            )
        }
    }

    override suspend fun getMovieDetail(movieId: Int) = withContext(Dispatchers.IO) {
        val response = moveInteractor.getMovieDetail(movieId)
        if (response?.isSuccessful == true) {
            Resource.Success(response.body()!!)
        } else {
            Resource.Error(
                IOException(response?.errorBody().toObject<ErrorResponse>(gson)?.message),
                networkManager.isConnected
            )
        }
    }
}