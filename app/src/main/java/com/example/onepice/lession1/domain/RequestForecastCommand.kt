package com.example.onepice.lession1.domain

import com.example.onepice.lession1.EosDataQr
import com.example.onepice.lession1.data.ForecastRequest

/**
 * 描    述：
 * 作    者：fantianwen
 * 时    间：2018/12/9  4:12 PM
 */
class RequestForecastCommand(val zipCode: String) : Command<EosDataQr> {
    override fun execute(): EosDataQr {
        val forecastRequest = ForecastRequest(zipCode)
        return forecastRequest.execute()
    }
}