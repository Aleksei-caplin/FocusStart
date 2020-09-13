package com.example.focusstart.ui.fragments

import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import com.example.focusstart.R
import com.example.focusstart.adapter.CurrencyListAdapter
import com.example.focusstart.model.Currency
import com.example.focusstart.model.CurrencyWrapper
import com.example.focusstart.net.Common
import com.example.focusstart.net.CurrencyListInterface
import com.example.focusstart.utils.DataGenerator
import com.example.focusstart.utils.replaceFragment
import kotlinx.android.synthetic.main.fragment_list.*
import retrofit2.Response


class ListFragment: BaseFragment(R.layout.fragment_list) {

    private lateinit var currencyList: CurrencyListInterface
    private lateinit var currencyProvider: CurrencyListAdapter

    override fun onResume() {
        super.onResume()
        currencyList = Common.retrofitService
        initViews()
    }

    private fun initViews() {


        currencyList.getCurrencyList().enqueue(object: Callback<CurrencyWrapper>{
            override fun onResponse(
                call: Call<CurrencyWrapper>,
                response: Response<CurrencyWrapper>
            ) {

                val currensyResponce = response.body()!!.valute
                val currensyResponceList = currensyResponce.map { it.value }

                currencyProvider = CurrencyListAdapter(currensyResponceList) {
                    replaceFragment(SingleFragment(it))
                }

                with(rv_currency_list){
                    adapter = currencyProvider
                    layoutManager = LinearLayoutManager(activity)
                }

            }

            override fun onFailure(call: Call<CurrencyWrapper>, t: Throwable) {
                Log.d("M_ListFragment_error", t.toString())
            }

        })


    }


}