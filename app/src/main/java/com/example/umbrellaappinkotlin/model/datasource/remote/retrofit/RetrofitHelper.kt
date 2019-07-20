package com.example.umbrellaappinkotlin.model.datasource.remote.retrofit

import com.example.umbrellaappinkotlin.model.forecastresponse.ForecastResponse
import com.example.umbrellaappinkotlin.model.weatherresponse.WeatherResponse
import com.example.umbrellaappinkotlin.model.datasource.remote.okhttp3.OkHttpHelper

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

import com.example.umbrellaappinkotlin.model.datasource.remote.retrofit.UrlConstants.Companion.BASE_URL

class RetrofitHelper {

    companion object {

        internal var weatherResponse: WeatherResponse? = null
        internal var forecastResponse: ForecastResponse? = null
    }

    fun getRetrofitInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpHelper.getClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    fun getService() : WeatherService {
        return getRetrofitInstance().create(WeatherService::class.java)
    }

    fun getForecastService() : ForecastService {
        return getRetrofitInstance().create(ForecastService::class.java)
    }

    fun getObservableService() : WeatherObservableService {
        return getRetrofitInstance().create(WeatherObservableService::class.java)
    }

    fun getForecastObservableService() : ForecastObservableService {
        return getRetrofitInstance().create(ForecastObservableService::class.java)
    }


}