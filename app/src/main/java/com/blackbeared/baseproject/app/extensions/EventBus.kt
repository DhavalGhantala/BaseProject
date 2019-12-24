package com.blackbeared.baseproject.app.extensions

import org.greenrobot.eventbus.EventBus

fun sendSticky(any: Any) {
    EventBus.getDefault().postSticky(any)
}

fun Any.send(){
    EventBus.getDefault().post(this)
}

fun sendIt(any: Any) {
    EventBus.getDefault().post(any)
}

fun removeSticky(any: Any) {
    EventBus.getDefault().removeStickyEvent(any)
}