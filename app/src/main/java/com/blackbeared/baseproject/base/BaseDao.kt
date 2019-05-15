package com.blackbeared.baseproject.base

import androidx.room.*
import androidx.sqlite.db.SimpleSQLiteQuery

@Dao
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(conversation: T): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMultiple(conversation: List<T>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(conversation: T): Long

    @Update
    fun update(conversation: T)

    @Delete
    fun delete(conversation: T)

    @RawQuery
    fun rawQuery(sqLiteQuery: SimpleSQLiteQuery): List<T>

}
