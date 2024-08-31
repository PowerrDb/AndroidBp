package com.razi.main_remote.retrofitApi

import com.razi.main_remote.BuildConfig
import com.razi.main_remote.dto.PopularMovieDto
import com.razi.main_remote.dto.RemoteMain
import retrofit2.http.GET
import retrofit2.http.Query

interface MainApi {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int,@Query("api_key") key: String=BuildConfig.API_KEY
    ): PopularMovieDto


}