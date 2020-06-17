package com.alaashammaa.entity

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.alaashammaa.entity.database.AppDatabase
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [21])
abstract class LocalDatabase {

    lateinit var db: AppDatabase

    @Before
    fun initDB() {
        this.db =
            Room.inMemoryDatabaseBuilder(getApplicationContext(), AppDatabase::class.java)
                .allowMainThreadQueries()
                .build()
    }

    @After
    fun closeDB() {
        this.db.close()
    }
}
