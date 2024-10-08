package com.razi.main_local.di

import android.app.Application
import androidx.room.Room
import com.razi.main_local.MainDatabase
import com.razi.main_local.dao.MainDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideDatabase(application: Application)  : MainDatabase{
        return Room.databaseBuilder(application,
            MainDatabase::class.java,
            "main_database.db").build()
    }

    @Singleton
    @Provides
    fun provideDao(mainDatabase: MainDatabase)  : MainDao{
        return mainDatabase.mainDao
    }


}