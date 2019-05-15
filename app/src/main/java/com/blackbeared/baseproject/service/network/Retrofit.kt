package com.blackbeared.baseproject.service.network

import com.blackbeared.baseproject.app.AUTH_TOKEN
import com.blackbeared.baseproject.app.BASE_URL
import com.blackbeared.baseproject.app.utils.PrefUtils
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {

    companion object {
        @Volatile
        private var instance: Retrofit? = null

        fun getInstance(prefs: PrefUtils) = instance ?: synchronized(this) {
            instance ?: Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient(prefs))
                .build().also {
                    instance = it
                }
        }

        private fun getClient(prefs: PrefUtils): OkHttpClient {
            return OkHttpClient.Builder()
                .addInterceptor {
                    it.proceed(
                        it.request()
                            .newBuilder()
                            .addHeader("Authorization", "Bearer " + prefs.getPreference(AUTH_TOKEN))
                            .addHeader("Platform", "Android")
                            .build()
                    )
                }
                .build()
        }
    }
}
