package com.blackbeared.baseproject.app.extensions

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager

fun Context.getScreenWidth(): Int {
    val displayMetrics = DisplayMetrics()
    (getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.getMetrics(displayMetrics)
    return displayMetrics.widthPixels
}


enum class DisplayType {
    TOAST,
    LONG_TOAST,
    SNACKBAR,
    ALERT
}