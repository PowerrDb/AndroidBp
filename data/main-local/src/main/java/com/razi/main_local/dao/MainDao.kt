package com.razi.main_local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.razi.main_local.model.MainEntity


@Dao
interface MainDao {

    @Upsert
    suspend fun upsertDataEntity(noteEntity: MainEntity)

    @Query("SELECT * FROM mainentity")
    suspend fun getAllDataEntities(): List<MainEntity>

    @Delete
    suspend fun deleteDataEntity(noteEntity: MainEntity)

}






















