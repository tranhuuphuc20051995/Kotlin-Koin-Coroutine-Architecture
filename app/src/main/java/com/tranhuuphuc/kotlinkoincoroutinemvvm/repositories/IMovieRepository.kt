package com.tranhuuphuc.kotlinkoincoroutinemvvm.repositories

import com.tranhuuphuc.kotlinkoincoroutinemvvm.models.Movie
import com.tranhuuphuc.kotlinkoincoroutinemvvm.models.Video
import com.tranhuuphuc.kotlinkoincoroutinemvvm.models.bases.BaseResponse
import com.tranhuuphuc.kotlinkoincoroutinemvvm.utils.Resource

/**
 * Created by TranHuuPhuc on 2019-07-27.
 */
interface IMovieRepository {
    suspend fun getNowPlaying(
        page: Int
    ): Resource<BaseResponse<List<Movie>>>

    suspend fun searchMovies(
        query: String,
        page: Int
    ): Resource<BaseResponse<List<Movie>>>

    suspend fun getVideoTrailer(
        movieId: Int
    ): Resource<BaseResponse<Video>>

    suspend fun getMovieDetail(
        movieId: Int
    ): Resource<BaseResponse<Movie>>

}