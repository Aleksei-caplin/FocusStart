package com.example.focusstart.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import com.example.focusstart.viewmodels.base.BaseViewModel

abstract class BaseActivity<T: BaseViewModel>:  AppCompatActivity()  {

    protected abstract val viewModel: T
    protected abstract val layout: Int
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
    }

}