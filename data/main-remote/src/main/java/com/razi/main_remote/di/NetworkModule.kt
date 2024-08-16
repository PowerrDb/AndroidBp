package com.razi.main_remote.di

import android.util.Log
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.razi.main_remote.retrofitApi.MainApi
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Singleton
    @Provides
    fun provideOkHttpClient() : OkHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor (
            HttpLoggingInterceptor { message ->
                println("LOG-NET: $message")

            }.apply {
                level = HttpLoggingInterceptor.Level.BODY
            },
        ).build()


    @Provides
    fun providesJson(): Json = Json {
        ignoreUnknownKeys = true
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        client: OkHttpClient,
        json: Json,
    ) :Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .client(client)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()

    }
    @Singleton
    @Provides
    fun provideMarketsApi(
        retrofit: Retrofit,
    ): MainApi = retrofit.create(MainApi::class.java)


}