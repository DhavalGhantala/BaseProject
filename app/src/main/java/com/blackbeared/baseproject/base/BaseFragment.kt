package com.blackbeared.baseproject.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.blackbeared.baseproject.app.di.interfaces.RepositoryTree
import com.blackbeared.baseproject.app.utils.PrefUtils
import org.greenrobot.eventbus.EventBus
import org.koin.android.ext.android.inject

abstract class BaseFragment<T : ViewDataBinding>(@LayoutRes val resId: Int) : Fragment() {

    lateinit var binding: T

    val prefs by inject<PrefUtils>()
    val tree by inject<RepositoryTree>()

    var useBus = false

    abstract fun init(): Boolean

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, resId, container, false) as T
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        useBus = init()
    }

    override fun onStart() {
        super.onStart()
        if (useBus)
            EventBus.getDefault().register(this@BaseFragment)
    }

    override fun onStop() {
        if (useBus)
            EventBus.getDefault().unregister(this@BaseFragment)
        super.onStop()
    }
}
