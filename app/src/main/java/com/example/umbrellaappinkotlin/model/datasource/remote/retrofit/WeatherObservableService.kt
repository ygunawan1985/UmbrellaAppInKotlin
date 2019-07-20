package com.example.umbrellaappinkotlin.model.datasource.remote.retrofit

import com.example.umbrellaappinkotlin.model.datasource.remote.retrofit.UrlConstants.Companion.PATH
import com.example.umbrellaappinkotlin.model.datasource.remote.retrofit.UrlConstants.Companion.QUERY_APPID
import com.example.umbrellaappinkotlin.model.datasource.remote.retrofit.UrlConstants.Companion.QUERY_ZIP
import com.example.umbrellaappinkotlin.model.weatherresponse.WeatherResponse

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherObservableService {

    @GET(PATH)
    fun getWeatherResponse(
        @Query(QUERY_ZIP) zip: String,
        @Query(QUERY_APPID) APPID: String
    ): Observable<WeatherResponse>
}