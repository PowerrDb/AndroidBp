package com.razi.main_local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.razi.main_local.dao.MainDao
import com.razi.main_local.model.MainEntity

@Database(entities = [MainEntity::class], version = 1)
  abstract class MainDatabase : RoomDatabase() {
    abstract val mainDao : MainDao
}