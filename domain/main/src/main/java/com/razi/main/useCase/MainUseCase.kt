package com.razi.main.useCase

import com.razi.main.repository.MainRepository
import javax.inject.Inject

open class MainUseCase @Inject constructor(private val mainRepository: MainRepository) {
    fun getDataList()  =  mainRepository.getListOfData()

    open suspend fun getPopularMovies()  =  mainRepository.getPopularMovies()

}