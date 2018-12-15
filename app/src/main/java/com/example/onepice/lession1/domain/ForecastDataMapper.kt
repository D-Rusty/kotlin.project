//package com.example.onepice.lession1.domain
//
//import com.example.onepice.lession1.data.ForecastResult
//import java.text.DateFormat
//import java.util.*
//
//import com.example.onepice.lession1.data.Forecast
//import com.example.onepice.lession1.domain.Forecast as ModelForecast
//
///**
// * 描    述：
// * 作    者：fantianwen
// * 时    间：2018/12/9  3:42 PM
// */
//class ForecastDataMapper {
//
//
//    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
//        return ForecastList(forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))
//    }
//
//    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
//        return list.map {
//            convertForecastItemToDomain(it)
//        }
//    }
//
//    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
//        return ModelForecast(
//            convertData(forecast.dt),
//            forecast.weather[0].description, forecast.temp.max.toInt(), forecast.temp.min.toInt()
//        )
//    }
//
//    private fun convertData(date: Long): String {
//        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
//        return df.format(date * 1000)
//    }
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
