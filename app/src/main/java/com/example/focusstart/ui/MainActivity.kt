package com.example.focusstart.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.focusstart.R
import com.example.focusstart.ui.fragments.ListFragment
import com.example.focusstart.utils.APP_ACTIVITY
import com.example.focusstart.utils.replaceFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        APP_ACTIVITY = this
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFuns()
    }

    private fun initFields() {

    }

    private fun initFuns() {
        setSupportActionBar(toolbar)
        replaceFragment(ListFragment())
    }
}