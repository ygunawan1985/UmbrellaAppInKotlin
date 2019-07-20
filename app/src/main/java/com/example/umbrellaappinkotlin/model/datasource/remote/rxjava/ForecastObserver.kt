package com.example.umbrellaappinkotlin.model.datasource.remote.rxjava

import android.util.Log

import com.example.umbrellaappinkotlin.model.forecastresponse.ForecastResponse

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class ForecastObserver(internal var callback: Callback) : Observer<ForecastResponse> {

    private lateinit var forecastResponse: ForecastResponse

    override fun onSubscribe(d: Disposable) {

    }

    override fun onNext(forecastResponse: ForecastResponse) {
        this.forecastResponse = forecastResponse
    }

    override fun onError(e: Throwable) {
        Log.e("TAG_FORECAST", "whatever", e)
    }

    override fun onComplete() {
        callback.getForecastResponse(forecastResponse)
    }
}
