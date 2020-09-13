package com.example.focusstart.net

object Common {

    private const val BASE_CURRENCY_URL = "https://www.cbr-xml-daily.ru/"

    val retrofitService: CurrencyListInterface
        get() = CurrencyApiClient.getClient(BASE_CURRENCY_URL).create(CurrencyListInterface::class.java)
}