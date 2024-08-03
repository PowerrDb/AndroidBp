package com.razi.main_remote.retrofitApi

import com.razi.main_remote.dto.NetworkTopic
import retrofit2.http.GET
import retrofit2.http.Query

interface MainApi {
    @GET(value = "topics")
    suspend fun getTopics():  List<NetworkTopic>

}