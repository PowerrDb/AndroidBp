package com.razi.main_remote.retrofitApi

import com.razi.main_remote.dto.PopularMovieDto
import com.razi.main_remote.dto.RemoteMain
import retrofit2.http.GET
import retrofit2.http.Query

interface MainApi {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int,@Query("api_key") key: String="a921fa0aef3e51da58481c65947d3687"
    ): PopularMovieDto


}