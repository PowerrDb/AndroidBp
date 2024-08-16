package com.razi.main_repository.repository

import android.net.http.HttpException
import com.razi.main.model.MainDataModel
import com.razi.main.model.PopularMovie
import com.razi.main.model.Resource
import com.razi.main.repository.MainRepository
import com.razi.main_local.dao.MainDao
import com.razi.main_remote.retrofitApi.MainApi
import com.razi.main_repository.mapper.toDomain
import com.razi.main_repository.mapper.toEntity
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

    override suspend fun getPopularMovies(): Flow<Resource<List<PopularMovie>>> = flow {
        try {
            val detail = api.getPopularMovies(1).movies.map { mm->mm.toDomain() }
            emit(Resource.Success(detail))
        } catch (e: Exception) {
            emit(Resource.Error(exception = e))
        }catch (ea: HttpException) {
            emit(Resource.Error(exception = ea))
        }
    }
}