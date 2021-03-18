package com.example.focusstart.viewmodels

import androidx.lifecycle.MediatorLiveData
import com.example.focusstart.model.Currency
import com.example.focusstart.model.CurrencyWrapper
import com.example.focusstart.repo.MainRepsitoriy
import com.example.focusstart.viewmodels.base.BaseViewModel


class MainViewModel: BaseViewModel() {

    val repository = MainRepsitoriy()
    val currencyItems = MediatorLiveData<List<Currency>>()

    fun getCurrencyLIst() {
        val result = repository.getCurrencyData()

        currencyItems.addSource(result) {
            currencyItems.value = result.value
        }
    }
}