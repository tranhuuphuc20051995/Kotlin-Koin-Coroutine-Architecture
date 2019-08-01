package com.tranhuuphuc.kotlinkoincoroutinemvvm.managers.movie

import com.tranhuuphuc.kotlinkoincoroutinemvvm.databases.models.Movie
import com.tranhuuphuc.kotlinkoincoroutinemvvm.databases.models.Video
import com.tranhuuphuc.kotlinkoincoroutinemvvm.databases.models.bases.BaseResponse
import com.tranhuuphuc.kotlinkoincoroutinemvvm.utils.Resource

/**
 * Created by TranHuuPhuc on 2019-08-02.
 */
interface MovieManager {
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

    suspend fun getMovieFavorite(
    ): Resource<List<Movie>>

    suspend fun addMovieFavorite(
        movie: Movie
    ): Resource<Boolean>
}