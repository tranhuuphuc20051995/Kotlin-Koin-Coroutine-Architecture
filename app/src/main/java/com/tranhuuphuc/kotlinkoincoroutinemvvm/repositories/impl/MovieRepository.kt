package com.tranhuuphuc.kotlinkoincoroutinemvvm.repositories.impl

import com.google.gson.Gson
import com.tranhuuphuc.kotlinkoincoroutinemvvm.BuildConfig
import com.tranhuuphuc.kotlinkoincoroutinemvvm.apis.MovieApi
import com.tranhuuphuc.kotlinkoincoroutinemvvm.repositories.IMovieRepository
import com.tranhuuphuc.kotlinkoincoroutinemvvm.utils.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

/**
 * Created by TranHuuPhuc on 2019-07-27.
 */
class MovieRepository(
        private val movieApi: MovieApi,
        private val networkManager: NetworkManager,
        private val gson: Gson
) : IMovieRepository {
    override suspend fun getNowPlaying(page: Int) = withContext(Dispatchers.IO) {
        val response = safeApiCall { movieApi.getNowPlaying(BuildConfig.API_KEY, page).await() }
        val nowMoviesResponse = response?.body()
        if (response?.isSuccessful == true && nowMoviesResponse != null && nowMoviesResponse.results != null) {
            Resource.Success(nowMoviesResponse)
        } else {
            Resource.Error(
                    IOException(response?.errorBody().toObject<ErrorResponse>(gson)?.message),
                    networkManager.isConnected
            )
        }
    }

    override suspend fun searchMovies(query: String, page: Int) = withContext(Dispatchers.IO) {
        val response = safeApiCall { movieApi.searchMovies(BuildConfig.API_KEY, query, page).await() }
        val moviesResponse = response?.body()
        if (response?.isSuccessful == true && moviesResponse != null && moviesResponse.results != null) {
            Resource.Success(moviesResponse)
        } else {
            Resource.Error(
                    IOException(response?.errorBody().toObject<ErrorResponse>(gson)?.message),
                    networkManager.isConnected
            )
        }
    }

    override suspend fun getVideoTrailer(movieId: Int) = withContext(Dispatchers.IO) {
        val response = safeApiCall { movieApi.getVideoTrailer(BuildConfig.API_KEY, movieId).await() }
        val videoTrailerResponse = response?.body()
        if (response?.isSuccessful == true && videoTrailerResponse != null && videoTrailerResponse.results != null) {
            Resource.Success(videoTrailerResponse)
        } else {
            Resource.Error(
                    IOException(response?.errorBody().toObject<ErrorResponse>(gson)?.message),
                    networkManager.isConnected
            )
        }
    }

    override suspend fun getMovieDetail(movieId: Int) = withContext(Dispatchers.IO) {
        val response = safeApiCall { movieApi.getMovieDetail(BuildConfig.API_KEY, movieId).await() }
        val movieDetailResponse = response?.body()
        if (response?.isSuccessful == true && movieDetailResponse != null && movieDetailResponse.results != null) {
            Resource.Success(movieDetailResponse)
        } else {
            Resource.Error(
                    IOException(response?.errorBody().toObject<ErrorResponse>(gson)?.message),
                    networkManager.isConnected
            )
        }
    }

}