package com.blackbeared.baseproject.app.di.providers

import com.blackbeared.baseproject.app.di.interfaces.ApiProvider
import com.blackbeared.baseproject.app.utils.PrefUtils
import com.blackbeared.baseproject.base.BaseApiResponse
import com.blackbeared.baseproject.service.network.NetworkCall
import com.blackbeared.baseproject.service.network.NetworkService
import com.blackbeared.baseproject.service.network.Retrofit

class ApiProviderImplementation(prefs: PrefUtils) : ApiProvider {

    val nService by lazy {
        Retrofit.getInstance(prefs).create(NetworkService::class.java)
    }

    override fun getNetworkService() = nService

    override fun <T : BaseApiResponse> getNetworkCall(): NetworkCall<T> {
        return NetworkCall()
    }
}
