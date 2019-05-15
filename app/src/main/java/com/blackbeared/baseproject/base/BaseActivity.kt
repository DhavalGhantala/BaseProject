package com.blackbeared.baseproject.base


import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.blackbeared.baseproject.app.di.interfaces.RepositoryTree
import com.blackbeared.baseproject.app.utils.PrefUtils
import org.greenrobot.eventbus.EventBus
import org.koin.android.ext.android.inject
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

@SuppressLint("Registered")
abstract class BaseActivity<T : ViewDataBinding>(@LayoutRes val resId: Int) : AppCompatActivity() {

    val prefs by inject<PrefUtils>()
    val tree by inject<RepositoryTree>()

    lateinit var binding: T

    var userBus = false

    abstract fun init(): Boolean

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        binding = DataBindingUtil.setContentView(this@BaseActivity, resId) as T
        userBus = init()
    }

    override fun onStart() {
        super.onStart()
        if (userBus)
            EventBus.getDefault().register(this@BaseActivity)
    }

    override fun onStop() {
        if (userBus)
            EventBus.getDefault().unregister(this@BaseActivity)
        super.onStop()
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }
}
