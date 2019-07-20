package com.example.umbrellaappinkotlin.model.datasource.remote.rxjava

import com.example.umbrellaappinkotlin.model.datasource.remote.retrofit.RetrofitHelper

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WeatherRepo {

    companion object {
        fun getWeather(callback: Callback, zip: Int, APPID: String) {
            RetrofitHelper()
                .getObservableService()
                .getWeatherResponse(zip.toString(), APPID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(WeatherObserver(callback))
        }
    }
}
