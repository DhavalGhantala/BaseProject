package com.blackbeared.baseproject.app.utils

import android.content.Context
import android.content.SharedPreferences
import com.blackbeared.baseproject.BuildConfig
import com.blackbeared.baseproject.service.storage.database.MyDatabase
import org.jetbrains.anko.doAsync

class PrefUtils(val context: Context) {

    private fun getSharedPreference(): SharedPreferences {
        return context.getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE)
    }

    fun setPreference(key: String, value: String) {
        getSharedPreference().edit().putString(key, value).apply()
    }

    fun getPreference(key: String): String {
        return getSharedPreference().getString(key, "") ?: ""
    }

    // TODO : Delete User from Account Manager As Well
    fun logout() {
        getSharedPreference().edit().clear().apply()
        doAsync {
            MyDatabase.getInstance(context).clearAllTables()
        }
        // context.startActivity(context.intentFor<LoginActivity>().clearTask().clearTop().newTask().singleTop())
    }
}
