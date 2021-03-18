package com.example.focusstart.ui.fragments

import android.annotation.SuppressLint
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.focusstart.R
import com.example.focusstart.model.Currency
import com.example.focusstart.ui.base.BaseFragment
import com.example.focusstart.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.fragment_single.*

class SingleFragment: BaseFragment<MainViewModel>() {

    override val viewModel: MainViewModel by activityViewModels()
    override val layout: Int = R.layout.fragment_single

    val args: SingleFragmentArgs by navArgs()

    override fun setupViews() {

        single_page_title.text = "Конвертировать рубли в ${args.title}"
        single_page_input.addTextChangedListener (object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            @SuppressLint("SetTextI18n")
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val inputVal = s.toString().replace("[^\\d]".toRegex(), "")
                if(inputVal.isNotBlank()) {
                    val res = inputVal.toFloat() / args.value.toFloat()
                    single_page_result.text = res.toString()
                }

            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
    }
}

