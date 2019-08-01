package com.tranhuuphuc.kotlinkoincoroutinemvvm.networks.interactors

import com.tranhuuphuc.kotlinkoincoroutinemvvm.databases.models.Movie
import com.tranhuuphuc.kotlinkoincoroutinemvvm.databases.models.Video
import com.tranhuuphuc.kotlinkoincoroutinemvvm.databases.models.bases.BaseResponse
import retrofit2.Response


/**
 * Created by TranHuuPhuc on 2019-08-02.
 */
interface MovieInteractor {
    suspend fun getNowPlaying(
        page: Int
    ): Response<BaseResponse<List<Movie>>>?

    suspend fun searchMovies(
        query: String,
        page: Int
    ): Response<BaseResponse<List<Movie>>>?

    suspend fun getVideoTrailer(
        movieId: Int
    ): Response<BaseResponse<Video>>?

    suspend fun getMovieDetail(
        movieId: Int
    ): Response<BaseResponse<Movie>>?

}