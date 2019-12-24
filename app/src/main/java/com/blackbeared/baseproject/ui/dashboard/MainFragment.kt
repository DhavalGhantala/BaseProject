package com.blackbeared.baseproject.ui.dashboard

import android.app.Activity
import android.widget.Toast
import com.blackbeared.baseproject.R
import com.blackbeared.baseproject.app.extensions.DisplayType
import com.blackbeared.baseproject.app.extensions.getScreenWidth
import com.blackbeared.baseproject.app.extensions.showAlert
import com.blackbeared.baseproject.base.BaseActivity
import com.blackbeared.baseproject.base.BaseFragment
import com.blackbeared.baseproject.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainFragment : BaseFragment<ActivityMainBinding>(R.layout.activity_main) {


    var name: Int? = null

    override fun init(): Boolean {

        var c : Int = name?:0

        context?.showAlert(context = context as Activity ,msg = "Hello", type = DisplayType.ALERT , pcallback = {

        })

        var width = context!!.getScreenWidth()
        return false
    }
}
