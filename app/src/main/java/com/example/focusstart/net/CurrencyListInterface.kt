package com.example.focusstart.net

import com.example.focusstart.model.CurrencyWrapper
import retrofit2.Call
import retrofit2.http.GET

interface CurrencyListInterface {

    @GET("daily_json.js")
    fun getCurrencyList(): Call<CurrencyWrapper>
}