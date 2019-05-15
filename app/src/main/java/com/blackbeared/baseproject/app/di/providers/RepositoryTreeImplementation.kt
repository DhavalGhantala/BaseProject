package com.blackbeared.baseproject.app.di.providers

import android.content.Context
import com.blackbeared.baseproject.app.di.interfaces.RepositoryTree
import com.blackbeared.baseproject.service.storage.database.MyDatabase
import com.blackbeared.baseproject.service.storage.repository.TestRepository

class RepositoryTreeImplementation(context: Context) : RepositoryTree {

    private val tRepository by lazy {
        TestRepository.getInstance(MyDatabase.getInstance(context).testDao())
    }

    override fun getTestRepository() = tRepository
}
