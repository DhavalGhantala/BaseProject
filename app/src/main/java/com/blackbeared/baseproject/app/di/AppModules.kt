package com.blackbeared.baseproject.app.di

import com.blackbeared.baseproject.app.di.interfaces.ApiProvider
import com.blackbeared.baseproject.app.di.interfaces.RepositoryTree
import com.blackbeared.baseproject.app.di.providers.ApiProviderImplementation
import com.blackbeared.baseproject.app.di.providers.RepositoryTreeImplementation
import com.blackbeared.baseproject.app.utils.FileUtils
import com.blackbeared.baseproject.app.utils.MathUtils
import com.blackbeared.baseproject.app.utils.NetworkUtils
import com.blackbeared.baseproject.app.utils.PrefUtils
import com.blackbeared.baseproject.ui.auth.login.viewmodel.LoginViewModel
import org.koin.dsl.module.module

object AppModules {
    val utilModule = module {
        single { PrefUtils(get()) }
        single { NetworkUtils(get()) }
        single { MathUtils(get()) }
        single { FileUtils(get()) }
    }



    val dataModule = module {
        single<RepositoryTree> { RepositoryTreeImplementation(get()) }
        single<ApiProvider> { ApiProviderImplementation(get()) }
    }

    val viewModel = module {
        single { LoginViewModel(get(), get()) }
    }

}