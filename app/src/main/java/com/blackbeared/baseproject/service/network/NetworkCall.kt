package com.blackbeared.baseproject.service.network

import android.util.Log
import com.blackbeared.baseproject.BuildConfig
import com.blackbeared.baseproject.app.*
import com.blackbeared.baseproject.app.extensions.DIComponent
import com.blackbeared.baseproject.app.extensions.inject
import com.blackbeared.baseproject.app.utils.NetworkUtils
import com.blackbeared.baseproject.base.BaseApiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkCall<T : BaseApiResponse> : DIComponent {

    fun makeCall(call: Call<T>, callback: NetworkCallback<T>) {
        if (!inject<NetworkUtils>().value.isNetworkAvailable()) {
            callback.onErrorResponse(MSG_INTERNET_UNAVAILABLE, CODE_INTERNET_UNAVAILABLE, true)

            if (BuildConfig.DEBUG)
                Log.d("21 " + call.request().url().pathSegments().last(), MSG_INTERNET_UNAVAILABLE)
        } else {
            continueCall(call, callback)
        }
    }

    private fun continueCall(call: Call<T>, callback: NetworkCallback<T>) {
        call.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                val res = response.body() as BaseApiResponse
                when {
                    res.status == true -> {
                        if (res.statusCode == 200) {
                            callback.onSuccessResponse(response.body() as T)

                            if (BuildConfig.DEBUG)
                                Log.d(
                                    "37 " + call.request().url().pathSegments().last(),
                                    (response.body() as T).message ?: ""
                                )
                        } else {
                            callback.onErrorResponse(res.message ?: "", res.statusCode ?: 0, false)

                            if (BuildConfig.DEBUG)
                                Log.d(
                                    "42 " + call.request().url().pathSegments().last(),
                                    (response.body() as T).message ?: ""
                                )
                        }
                    }
                    else -> {
                        if (res.statusCode == CODE_UNAUTHORIZED) {
                            callback.onErrorResponse(res.message ?: MSG_UNAUTHORISED, CODE_UNAUTHORIZED, false)

                            if (BuildConfig.DEBUG)
                                Log.d(
                                    "50 " + call.request().url().pathSegments().last(),
                                    (response.body() as T).message ?: ""
                                )
                        } else {
                            callback.onErrorResponse(
                                res.message ?: MSG_SOMETHING_WENT_WRONG,
                                CODE_SOMETHING_WENT_WRONG,
                                false
                            )
                            if (BuildConfig.DEBUG)
                                Log.d(
                                    "58 " + call.request().url().pathSegments().last(),
                                    (response.body() as T).message ?: ""
                                )
                        }
                    }
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                callback.onErrorResponse(t.message ?: FAILED_PARSING_RESPONSE, CODE_FAILED_PARSING_RESPONSE, false)
                if (BuildConfig.DEBUG)
                    Log.d("67 " + call.request().url().pathSegments().last(), t.message ?: "")
            }
        })
    }
}
