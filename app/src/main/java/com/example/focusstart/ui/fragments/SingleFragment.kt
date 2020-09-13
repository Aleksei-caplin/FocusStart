package com.example.focusstart.ui.fragments

import android.annotation.SuppressLint
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.core.widget.addTextChangedListener
import com.example.focusstart.R
import com.example.focusstart.model.Currency
import kotlinx.android.synthetic.main.fragment_single.*

class SingleFragment(val model: Currency) : BaseFragment(R.layout.fragment_single) {

    override fun onResume() {
        super.onResume()
        Log.d("M_SingleFragment", model.toString())
        single_page_title.text = "Конвертировать рубли в ${model.name}"
        single_page_input.addTextChangedListener (object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            @SuppressLint("SetTextI18n")
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val inputVal = s.toString().replace("[^\\d]".toRegex(), "")
                val res = inputVal.toFloat()/model.value.toFloat()
                single_page_result.text = res.toString()
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
    }
}

