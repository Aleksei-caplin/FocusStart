package com.example.focusstart.utils

import com.example.focusstart.model.Currency

object DataGenerator {

    fun generateCamsList(): List<Currency> {
        val currencyList = ArrayList<Currency>()

        currencyList.add(Currency("Австралийский доллар", "54.587"))
        currencyList.add(Currency("Азербайджанский манат", "44.0786"))


        return currencyList
    }
}