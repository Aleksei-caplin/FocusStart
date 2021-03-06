package com.example.focusstart.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.focusstart.ui.MainActivity
import com.example.focusstart.viewmodels.base.BaseViewModel

abstract class BaseFragment<T: BaseViewModel> : Fragment() {

    val main: MainActivity
        get() = activity as MainActivity

    protected abstract val viewModel: T
    protected abstract val layout: Int

    abstract fun setupViews()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(layout, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }
}