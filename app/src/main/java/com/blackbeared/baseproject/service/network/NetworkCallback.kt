package com.blackbeared.baseproject.service.network

import com.blackbeared.baseproject.base.BaseApiResponse

interface NetworkCallback<T : BaseApiResponse> {
    fun onSuccessResponse(response: T)
    fun onErrorResponse(error: String, errorCode: Int, isNetworkError: Boolean)
}
