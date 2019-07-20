package com.example.umbrellaappinkotlin.model.datasource.remote.rxjava

import com.example.umbrellaappinkotlin.model.forecastresponse.ForecastResponse
import com.example.umbrellaappinkotlin.model.weatherresponse.WeatherResponse

interface Callback {
    fun getWeatherResponse(weatherResponse: WeatherResponse)

    fun getForecastResponse(forecastResponse: ForecastResponse)
}
