package com.blackbeared.baseproject.base

import android.app.Application
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.AndroidViewModel
import com.blackbeared.baseproject.app.di.interfaces.ApiProvider
import com.blackbeared.baseproject.service.network.NetworkCallback
import retrofit2.Call

open class BaseApiViewModel(val apiProvider: ApiProvider, application: Application) : AndroidViewModel(application) {

    val loading: ObservableBoolean = ObservableBoolean(false)

    fun <T : BaseApiResponse> validateAndCall(isValid: () -> Boolean, call: Call<T>, callback: NetworkCallback<T>) {

        if (!isValid.invoke()) {
            return
        }

        loading.set(true)
        apiProvider.getNetworkCall<T>().makeCall(call, object : NetworkCallback<T> {
            override fun onSuccessResponse(response: T) {
                loading.set(false)

                callback.onSuccessResponse(response)
            }

            override fun onErrorResponse(error: String, errorCode: Int, isNetworkError: Boolean) {
                loading.set(false)

                callback.onErrorResponse(error, errorCode, isNetworkError)
            }
        })
    }
}
