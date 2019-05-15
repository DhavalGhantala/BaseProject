package com.blackbeared.baseproject.service.network

import com.blackbeared.baseproject.app.LOGIN
import com.blackbeared.baseproject.app.REGISTER
import com.blackbeared.baseproject.ui.auth.login.api.LoginRequestModel
import com.blackbeared.baseproject.ui.auth.login.api.LoginResponseModel
import com.blackbeared.baseproject.ui.auth.register.api.RegisterRequestModel
import com.blackbeared.baseproject.ui.auth.register.api.RegisterResponseModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET

interface NetworkService {

    @GET(LOGIN)
    fun login(@Body request: LoginRequestModel): Call<LoginResponseModel>

    @GET(REGISTER)
    fun register(@Body user: RegisterRequestModel): Call<RegisterResponseModel>
}
