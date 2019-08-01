package com.tranhuuphuc.kotlinkoincoroutinemvvm.networks.interactors.impl

import com.tranhuuphuc.kotlinkoincoroutinemvvm.BuildConfig
import com.tranhuuphuc.kotlinkoincoroutinemvvm.databases.models.Movie
import com.tranhuuphuc.kotlinkoincoroutinemvvm.databases.models.Video
import com.tranhuuphuc.kotlinkoincoroutinemvvm.databases.models.bases.BaseResponse
import com.tranhuuphuc.kotlinkoincoroutinemvvm.networks.interactors.MovieInteractor
import com.tranhuuphuc.kotlinkoincoroutinemvvm.networks.services.MovieService
import com.tranhuuphuc.kotlinkoincoroutinemvvm.utils.safeApiCall
import retrofit2.Response

/**
 * Created by TranHuuPhuc on 2019-08-02.
 */
class MovieInteractorImpl(
    private val movieService: MovieService
) : MovieInteractor {
    override suspend fun searchMovies(query: String, page: Int): Response<BaseResponse<List<Movie>>>? =
        safeApiCall { movieService.searchMovies(BuildConfig.API_KEY, query, page).await() }

    override suspend fun getVideoTrailer(movieId: Int): Response<BaseResponse<Video>>? =
        safeApiCall { movieService.getVideoTrailer(BuildConfig.API_KEY, movieId).await() }

    override suspend fun getMovieDetail(movieId: Int): Response<BaseResponse<Movie>>? =
        safeApiCall { movieService.getMovieDetail(BuildConfig.API_KEY, movieId).await() }

    override suspend fun getNowPlaying(page: Int): Response<BaseResponse<List<Movie>>>? =
        safeApiCall { movieService.getNowPlaying(BuildConfig.API_KEY, page).await() }
}