package com.example.focusstart.model

import com.google.gson.annotations.SerializedName

data class CurrencyWrapper(
    @SerializedName("Valute")
    val valute: Map<String, Currency> = mapOf()
)

data class Currency(
    @SerializedName("Name")
    val name: String = "",
    @SerializedName("Value")
    val value: String = ""
)