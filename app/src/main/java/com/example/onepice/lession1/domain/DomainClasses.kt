package com.example.onepice.lession1.domain

/**
 * 描    述：
 * 作    者：fantianwen
 * 时    间：2018/12/9  3:36 PM
 */

data class ForecastList(
    val city: String, val country: String,
    val dailyForecast: List<Forecast>
)


data class Forecast(
    val date: String, val description: String, val high: Int,
    val low: Int
)