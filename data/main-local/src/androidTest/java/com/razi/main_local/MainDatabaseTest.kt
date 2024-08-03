package com.razi.main_local

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.razi.main_local.dao.MainDao
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.assertTrue

class MainDatabaseTest {

    lateinit var mainDatabase: MainDatabase
    private lateinit var mainDao: MainDao

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        mainDatabase = Room.inMemoryDatabaseBuilder(
            context,
            MainDatabase::class.java,
        ).build()
        mainDao=mainDatabase.mainDao
    }

    @After
    fun tearDown() {
        mainDatabase.close()
    }

    @Test
    fun getAllDataFromEmptyDb_listIsEmpty() = runTest {

        assertTrue(mainDao.getAllDataEntities().isEmpty())
        }



}