package com.blackbeared.baseproject.app.extensions

import java.text.SimpleDateFormat
import java.util.*

infix fun Long.toDateTimeString(format: DateTimeFormat): String {
    return SimpleDateFormat(format.format).format(Date(this))
}

enum class DateTimeFormat(val format: String) {
    DD_MM_YYYY("dd MM yyyy"),
    DD_MMM_YYYY("dd MMM, yyyy"),
    DD_MM_YYYY_HH_MM_A("dd MMM yyyy hh:mm a"),
    HH_MM_A("hh:mm a"),
    DD_MMMM_YY("dd MMMM yy"),
    DD_MMMM("dd MMMM"),
    HH_MM_SS("HH:mm:ss"),
    MM_SS("mm:ss");
}
