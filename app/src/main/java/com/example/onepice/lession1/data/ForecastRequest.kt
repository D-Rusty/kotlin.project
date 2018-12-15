package com.example.onepice.lession1.data

import com.example.onepice.lession1.EosDataQr
import com.google.gson.Gson
import java.net.URL

/**
 * 描    述：
 * 作    者：fantianwen
 * 时    间：2018/12/9  2:58 PM
 */
public class ForecastRequest(val zipCode: String) {
    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }

    fun execute(): EosDataQr {

        val forecastJsonStr =
            URL("https://api.eospark.com/api?module=account&action=get_account_info&apikey=a9564ebc3289b7a14551baf8ad5ec60a&account=helloworldjs").readText()

        return Gson().fromJson(forecastJsonStr, EosDataQr::class.java)
    }
}