package com.example.umbrellaappinkotlin.model.datasource.remote.rxjava

import com.example.umbrellaappinkotlin.model.datasource.remote.retrofit.RetrofitHelper

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ForecastRepo {

    companion object {
        fun getForecast(callback: Callback, zip: Int, APPID: String) {

            RetrofitHelper()
                .getForecastObservableService()
                .getForecastResponse(zip.toString(), APPID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(ForecastObserver(callback))
        }
    }
}
