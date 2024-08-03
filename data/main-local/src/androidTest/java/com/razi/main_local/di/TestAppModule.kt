package com.razi.main_local.di

import android.app.Application
import androidx.room.Room
import com.razi.main_local.MainDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TestAppModule {

    @Singleton
    @Provides
    fun provideDatabase(application: Application): MainDatabase {
        return Room.inMemoryDatabaseBuilder(
            application,
            MainDatabase::class.java
        ).build()
    }
}