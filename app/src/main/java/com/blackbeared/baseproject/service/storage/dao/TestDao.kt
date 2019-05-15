package com.blackbeared.baseproject.service.storage.dao

import androidx.room.Dao
import androidx.room.Query
import com.blackbeared.baseproject.base.BaseDao
import com.blackbeared.baseproject.service.storage.tables.Test

@Dao
interface TestDao : BaseDao<Test> {

    @Query("select * from test")
    fun getAll(): List<Test>

}
