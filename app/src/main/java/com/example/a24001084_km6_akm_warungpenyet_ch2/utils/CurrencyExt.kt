package com.example.a24001084_km6_akm_warungpenyet_ch2.utils


import java.text.NumberFormat
import java.util.Locale

fun Double?.doubleToCurrency(language: String, country: String): String? {
    return try {
        val localeID = Locale(language, country)
        val numberFormat = NumberFormat.getCurrencyInstance(localeID)
        val formattedValue = numberFormat.format(this)
        formattedValue.replace(",00", ",-")
    } catch (e: Exception) {
        null
    }
}
fun Double?.toIndonesianFormat() = this.doubleToCurrency("in","ID")