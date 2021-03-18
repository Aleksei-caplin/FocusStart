package com.example.focusstart.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.focusstart.model.Currency
import com.example.focusstart.model.CurrencyWrapper
import com.example.focusstart.net.Common
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepsitoriy() {

    private val retrofitService = Common.retrofitService

    fun getCurrencyData(): LiveData<List<Currency>> {
        val data = MutableLiveData<List<Currency>>()

        retrofitService.getCurrencyList().enqueue(object : Callback<CurrencyWrapper> {
            override fun onResponse(call: Call<CurrencyWrapper>, response: Response<CurrencyWrapper>) {
                if (response.isSuccessful) {
                    val ff = response.body()!!.valute
                    data.value = ff.map { it.value }
                }
            }

            override fun onFailure(call: Call<CurrencyWrapper>, t: Throwable) {

            }

        })

        return data
    }
}