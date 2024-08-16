package com.razi.main.repository

import com.razi.main.model.MainDataModel
import com.razi.main.model.PopularMovie
import com.razi.main.model.Resource
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun getListOfData():Flow<List<MainDataModel>>
    suspend fun syncMainList()
    suspend fun getPopularMovies(): Flow<Resource<List<PopularMovie>>>
}