package com.tranhuuphuc.kotlinkoincoroutinemvvm.networks.services

import com.tranhuuphuc.kotlinkoincoroutinemvvm.models.Movie
import com.tranhuuphuc.kotlinkoincoroutinemvvm.models.Video
import com.tranhuuphuc.kotlinkoincoroutinemvvm.models.bases.BaseResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by TranHuuPhuc on 2019-07-27.
 */
interface MovieService {
    @GET("movie/now_playing")
    fun getNowPlaying(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): Deferred<Response<BaseResponse<List<Movie>>>>

    @GET("search/movie")
    fun searchMovies(
        @Query("api_key") apiKey: String,
        @Query("query") query: String,
        @Query("page") page: Int
    ): Deferred<Response<BaseResponse<List<Movie>>>>

    @GET("movie/{movieId}/videos")
    fun getVideoTrailer(
        @Query("api_key") apiKey: String,
        @Path("movieId") movieId: Int
    ): Deferred<Response<BaseResponse<Video>>>

    @GET("movie/{movieId}")
    fun getMovieDetail(
        @Query("api_key") apiKey: String,
        @Path("movieId") movieId: Int
    ): Deferred<Response<BaseResponse<Movie>>>

}