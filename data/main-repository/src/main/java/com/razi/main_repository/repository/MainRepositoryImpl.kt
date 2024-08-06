package com.razi.main_repository.repository

import com.razi.main.model.MainDataModel
import com.razi.main.repository.MainRepository
import com.razi.main_local.dao.MainDao
import com.razi.main_remote.retrofitApi.MainApi
import com.razi.main_repository.mapper.toMainDataModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val api: MainApi,
    private val dao: MainDao,
) : MainRepository {
    override fun getListOfData(): Flow<List<MainDataModel>> {
        return dao.getAllDataEntities().map { a->a.map { it.toMainDataModel() } }
    }

    override suspend fun syncMainList() {}
}