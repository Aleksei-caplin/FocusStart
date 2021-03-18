package com.example.focusstart.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.Navigation
import com.example.focusstart.R
import com.example.focusstart.ui.base.BaseActivity
import com.example.focusstart.utils.APP_ACTIVITY
import com.example.focusstart.viewmodels.MainViewModel

class MainActivity : BaseActivity<MainViewModel>() {

    override val viewModel: MainViewModel by viewModels()
    override val layout: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        APP_ACTIVITY = this
        navController = Navigation.findNavController(this, R.id.nav_host)
    }
}