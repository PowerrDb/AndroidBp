package com.razi.main_local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.razi.main_local.model.MainEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface MainDao {

    @Upsert
      fun upsertDataEntity(noteEntity: MainEntity)

    @Query("SELECT * FROM mainentity")
      fun getAllDataEntities(): Flow<List<MainEntity>>

    @Delete
      fun deleteDataEntity(noteEntity: MainEntity)

}






















