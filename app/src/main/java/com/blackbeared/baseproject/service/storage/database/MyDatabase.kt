package com.blackbeared.baseproject.service.storage.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.blackbeared.baseproject.service.storage.dao.TestDao
import com.blackbeared.baseproject.service.storage.tables.Test

@Database(entities = [Test::class], version = 23, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {

    abstract fun testDao(): TestDao

    companion object {
        @Volatile
        private var instance: MyDatabase? = null

        fun getInstance(context: Context) = instance ?: synchronized(this) {
            instance ?: Room.databaseBuilder(context.applicationContext, MyDatabase::class.java, "temp_db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
                .also { instance = it }
        }
    }
}
