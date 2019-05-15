package com.blackbeared.baseproject.app.extensions

import org.greenrobot.eventbus.EventBus

fun sendSticky(any: Any) {
    EventBus.getDefault().postSticky(any)
}

fun send(any: Any) {
    EventBus.getDefault().post(any)
}

fun removeSticky(any: Any) {
    EventBus.getDefault().removeStickyEvent(any)
}