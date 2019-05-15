package com.blackbeared.baseproject.app

import android.app.Application
import com.blackbeared.baseproject.R
import com.blackbeared.baseproject.app.di.AppModules
import org.koin.android.ext.android.startKoin
import uk.co.chrisjenx.calligraphy.CalligraphyConfig


class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(
            this@MyApplication, listOf(
                AppModules.dataModule,
                AppModules.utilModule,
                AppModules.viewModel
            )
        )

        CalligraphyConfig.initDefault(
            CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/semilight.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        )
    }
}
