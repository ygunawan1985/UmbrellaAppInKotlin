package com.example.umbrellaappinkotlin.model.datasource.remote.retrofit

import com.example.umbrellaappinkotlin.model.datasource.remote.retrofit.UrlConstants.Companion.PATH
import com.example.umbrellaappinkotlin.model.datasource.remote.retrofit.UrlConstants.Companion.QUERY_APPID
import com.example.umbrellaappinkotlin.model.datasource.remote.retrofit.UrlConstants.Companion.QUERY_ZIP
import com.example.umbrellaappinkotlin.model.weatherresponse.WeatherResponse

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET(PATH)
    fun getWeatherResponse(
        @Query(QUERY_ZIP) zip: String,
        @Query(QUERY_APPID) APPID: String
    ): Call<WeatherResponse>
}