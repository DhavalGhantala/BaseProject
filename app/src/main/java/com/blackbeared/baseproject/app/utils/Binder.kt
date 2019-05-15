package com.blackbeared.baseproject.app.utils

import com.blackbeared.baseproject.app.extensions.DateTimeFormat
import com.blackbeared.baseproject.app.extensions.toDateTimeString

class Binder {

    companion object {

        @JvmStatic
        fun getDateString(millis: Long) = millis toDateTimeString DateTimeFormat.DD_MMMM_YY
    }
}
