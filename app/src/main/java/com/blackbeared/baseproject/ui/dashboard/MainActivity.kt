package com.blackbeared.baseproject.ui.dashboard

import com.blackbeared.baseproject.R
import com.blackbeared.baseproject.app.Dashboard
import com.blackbeared.baseproject.app.extensions.getScreenWidth
import com.blackbeared.baseproject.app.extensions.send
import com.blackbeared.baseproject.app.extensions.toDateTimeString
import com.blackbeared.baseproject.base.BaseActivity
import com.blackbeared.baseproject.databinding.ActivityMainBinding
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun init(): Boolean {

        var users = ArrayList<User>()

        binding.user = User()


        Dashboard.ReceivedDataEvent().send()

        prefs.getPreference("sdfdsf")

        var asd = System.currentTimeMillis().toDateTimeString()

        var width = getScreenWidth()
        return true
    }


    @Subscribe(sticky = false, threadMode = ThreadMode.MAIN)
    fun onEent(event: Dashboard.ReceivedDataEvent) {

    }
}

class User {
    var fname: String = ""
    var lname: String = ""
    var age: String = ""
    var dob: String = ""
}