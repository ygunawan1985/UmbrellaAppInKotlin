package com.example.umbrellaappinkotlin.model.datasource.remote.retrofit

class UrlConstants {

    companion object {
        const val BASE_URL = "https://api.openweathermap.org/"
        const val PATH = "data/2.5/weather?"
        const val QUERY_ZIP = "zip"
        const val QUERY_APPID = "APPID"
        const val ICON_URL = "http://openweathermap.org/img/wn/"
        const val FORECAST_PATH = "data/2.5/forecast?"
    }
}
