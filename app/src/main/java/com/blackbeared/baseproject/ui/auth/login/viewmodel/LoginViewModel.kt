package com.blackbeared.baseproject.ui.auth.login.viewmodel

import android.app.Application
import android.view.View
import androidx.databinding.ObservableField
import com.blackbeared.baseproject.app.di.interfaces.ApiProvider
import com.blackbeared.baseproject.app.extensions.showMessage
import com.blackbeared.baseproject.base.BaseApiViewModel
import com.blackbeared.baseproject.service.network.NetworkCallback
import com.blackbeared.baseproject.ui.auth.login.api.LoginRequestModel
import com.blackbeared.baseproject.ui.auth.login.api.LoginResponseModel

class LoginViewModel(apiProvider: ApiProvider, application: Application) : BaseApiViewModel(apiProvider, application) {

    val username: ObservableField<String> = ObservableField("")
    val password: ObservableField<String> = ObservableField("")

    fun onSubmitClick(view: View) {

        val call = apiProvider.getNetworkService().login(getLoginRequest())
        validateAndCall({ isValid(view) }, call, object : NetworkCallback<LoginResponseModel> {
            override fun onSuccessResponse(response: LoginResponseModel) {

            }

            override fun onErrorResponse(error: String, errorCode: Int, isNetworkError: Boolean) {

            }
        })
    }

    private fun isValid(view: View): Boolean {
        return when {
            username.get()!!.length < 5 -> {
                view.showMessage("Invalid Username")
                false
            }
            else -> {
                true
            }
        }
    }

    private fun getLoginRequest(): LoginRequestModel {
        return LoginRequestModel(username.get()!!, password.get()!!)
    }
}
