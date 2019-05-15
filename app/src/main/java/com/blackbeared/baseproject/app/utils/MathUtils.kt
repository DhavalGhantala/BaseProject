package com.blackbeared.baseproject.app.utils

import android.content.Context
import android.content.Context.WINDOW_SERVICE
import android.util.DisplayMetrics
import android.view.WindowManager

class MathUtils(val context: Context) {

    var width: Int = 0
    var height: Int = 0

    init {
        val displayMetrics = DisplayMetrics()
        (context.getSystemService(WINDOW_SERVICE) as WindowManager).defaultDisplay.getMetrics(displayMetrics)
        height = displayMetrics.heightPixels
        width = displayMetrics.widthPixels
    }

    fun dpTOpx(dp: Float): Float {
        return dp * (context.resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)
    }

    fun pxTOdp(px: Float, context: Context): Float {
        return px / (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }

}
