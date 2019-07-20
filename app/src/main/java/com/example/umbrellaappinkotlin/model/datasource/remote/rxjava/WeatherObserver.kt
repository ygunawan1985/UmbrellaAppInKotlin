package com.example.umbrellaappinkotlin.model.datasource.remote.rxjava

import com.example.umbrellaappinkotlin.model.weatherresponse.WeatherResponse

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class WeatherObserver(internal var callback: Callback) : Observer<WeatherResponse> {
    private lateinit var weatherResponse: WeatherResponse

    override fun onSubscribe(d: Disposable) {
        //Do what is in here when we a object starts listening for emitting

    }

    override fun onNext(weatherResponse: WeatherResponse) {
        //Do this when we get an result
        //Log.d("TAG_RX", weatherResponse.getName());
        this.weatherResponse = weatherResponse
    }

    override fun onError(e: Throwable) {
        //Do this if something goes wrong
    }

    override fun onComplete() {
        callback.getWeatherResponse(weatherResponse)
    }

}
