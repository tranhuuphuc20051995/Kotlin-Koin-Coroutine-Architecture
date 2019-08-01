package com.tranhuuphuc.kotlinkoincoroutinemvvm.networks.interactors

import com.tranhuuphuc.kotlinkoincoroutinemvvm.models.Movie
import com.tranhuuphuc.kotlinkoincoroutinemvvm.models.Video
import com.tranhuuphuc.kotlinkoincoroutinemvvm.models.bases.BaseResponse
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