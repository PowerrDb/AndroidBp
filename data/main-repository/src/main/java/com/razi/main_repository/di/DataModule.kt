package com.razi.main_repository.di

import com.razi.main.repository.MainRepository
import com.razi.main_repository.repository.MainRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsMainRepository(
        repositoryImpl: MainRepositoryImpl
    ) : MainRepository
}