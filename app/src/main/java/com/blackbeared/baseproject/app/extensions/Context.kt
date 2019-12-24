package com.blackbeared.baseproject.app.extensions

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager
import android.widget.Toast


fun Context.getScreenWidth(): Int {
    val displayMetrics = DisplayMetrics()
    (getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.getMetrics(displayMetrics)
    return displayMetrics.widthPixels
}

fun Context.showAlert(
    context: Activity,
    msg: String,
    type: DisplayType = DisplayType.SNACKBAR,
    pcallback: (data: String) -> Unit,
    ncallback: () -> Unit = {}
) {
    when (type) {
        DisplayType.TOAST -> Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        DisplayType.LONG_TOAST -> TODO()
        DisplayType.SNACKBAR -> TODO()
        DisplayType.ALERT -> {
            AlertDialog.Builder(this)
                .setMessage(msg).setTitle("ok")
                .setPositiveButton("") { dialog, int ->
                    pcallback.invoke("final Response")
                    dialog.dismiss()
                }.setNegativeButton(""){ dialog, int ->
                    ncallback.invoke()
                    dialog.dismiss()
                }.show()
        }
    }
}

enum class DisplayType {
    TOAST,
    LONG_TOAST,
    SNACKBAR,
    ALERT
}