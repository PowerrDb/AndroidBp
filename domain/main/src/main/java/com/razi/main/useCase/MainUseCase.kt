package com.razi.main.useCase

import com.razi.main.model.MainDataModel
import com.razi.main.repository.MainRepository
import javax.inject.Inject

class MainUseCase @Inject constructor(private val mainRepository: MainRepository) {
    fun getDataList()  =  mainRepository.getListOfData()

}