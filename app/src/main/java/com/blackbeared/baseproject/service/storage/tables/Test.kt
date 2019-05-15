package com.blackbeared.baseproject.service.storage.tables

import androidx.annotation.NonNull
import androidx.recyclerview.widget.DiffUtil
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity(tableName = "test", indices = arrayOf(Index(value = ["_id"])))
class Test {

    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "_id")
    var _id: Long = 0L
    var name: String? = null
}

var TEST_DIFF_CALLBACK: DiffUtil.ItemCallback<Test> = object : DiffUtil.ItemCallback<Test>() {
    override fun areItemsTheSame(@NonNull oldItem: Test, @NonNull newItem: Test): Boolean {
        return oldItem._id == newItem._id
    }

    override fun areContentsTheSame(@NonNull oldItem: Test, @NonNull newItem: Test): Boolean {
        return oldItem._id == newItem._id && oldItem.name == newItem.name
    }
}

