package com.blackbeared.baseproject.app.di.interfaces

import com.blackbeared.baseproject.base.BaseApiResponse
import com.blackbeared.baseproject.service.network.NetworkCall
import com.blackbeared.baseproject.service.network.NetworkService

interface ApiProvider {
    fun getNetworkService(): NetworkService
    fun <T : BaseApiResponse> getNetworkCall(): NetworkCall<T>
}
