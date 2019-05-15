package com.blackbeared.baseproject.ui.auth.login.view

import com.blackbeared.baseproject.R
import com.blackbeared.baseproject.base.BaseActivity
import com.blackbeared.baseproject.databinding.ActivityLoginBinding
import com.blackbeared.baseproject.ui.auth.login.viewmodel.LoginViewModel
import org.koin.android.ext.android.inject

class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {

    override fun init(): Boolean {

        // Thats it // Remaining is done by Databinding
        binding.vm = inject<LoginViewModel>().value

        // Get Any Items from Database

        val testItems = tree.getTestRepository().getAll()
        return false
    }
}
