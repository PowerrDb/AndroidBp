package com.razi.main.repository

import com.razi.main.model.MainDataModel
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun getListOfData():Flow<List<MainDataModel>>
}