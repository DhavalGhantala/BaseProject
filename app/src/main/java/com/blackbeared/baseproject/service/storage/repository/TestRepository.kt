package com.blackbeared.baseproject.service.storage.repository

import com.blackbeared.baseproject.service.storage.dao.TestDao
import com.blackbeared.baseproject.service.storage.tables.Test
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

class TestRepository private constructor(val dao: TestDao) {

    fun insertMultiple(items: List<Test>) {
        runBlocking(Dispatchers.IO) {
            dao.insertMultiple(items)
        }
    }

    fun insert(posts: Test) {
        runBlocking(Dispatchers.IO) {
            dao.insert(posts)
        }
    }

    fun update(post: Test) {
        runBlocking(Dispatchers.IO) {
            dao.update(post)
        }
    }

    fun delete(post: Test) {
        runBlocking(Dispatchers.IO) {
            dao.delete(post)
        }
    }

    fun getAll() = runBlocking(Dispatchers.IO) {
        dao.getAll()
    }

    companion object {
        @Volatile
        private var instance: TestRepository? = null

        fun getInstance(dao: TestDao) =
            instance ?: synchronized(this) {
                instance ?: TestRepository(dao).also { instance = it }
            }
    }
}
