package com.blackbeared.baseproject.app.extensions

import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.material.snackbar.Snackbar
import org.jetbrains.anko.alert
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast


fun View.showMessage(message: String, title: String = "", displayType: DisplayType = DisplayType.SNACKBAR) {
    when (displayType) {

        DisplayType.TOAST -> {
            context.toast(message)
        }
        DisplayType.LONG_TOAST -> {
            context.longToast(message)
        }
        DisplayType.SNACKBAR -> {
            Snackbar.make(this, message, Snackbar.LENGTH_SHORT).show()
        }
        DisplayType.ALERT -> {
            context.alert(message, title).show()
        }
    }
}


fun <T : ViewDataBinding> View.getCustomDialog(@LayoutRes resId: Int): DProvider<T> {
    val dialog = Dialog(context)

    val binding = DataBindingUtil.inflate(LayoutInflater.from(context), resId, null, false) as T
    dialog.setContentView(binding.root)
    dialog.setCancelable(true)
    dialog.setCanceledOnTouchOutside(true)

    dialog.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
    return DProvider(dialog, binding)
}

class DProvider<T>(val dialog: Dialog, val binding: T)
