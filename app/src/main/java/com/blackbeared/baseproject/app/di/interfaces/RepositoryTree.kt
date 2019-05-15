package com.blackbeared.baseproject.app.di.interfaces

import com.blackbeared.baseproject.service.storage.repository.TestRepository

interface RepositoryTree {
    fun getTestRepository(): TestRepository
}
