package com.razi.main_remote.retrofitApi

import com.razi.main_remote.dto.RemoteMain
import retrofit2.http.GET

interface MainApi {
    @GET(value = "topics")
    suspend fun getTopics():  List<RemoteMain>

}