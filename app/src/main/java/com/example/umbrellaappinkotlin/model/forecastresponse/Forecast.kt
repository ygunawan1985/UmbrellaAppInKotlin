package com.example.umbrellaappinkotlin.model.forecastresponse

import android.os.Parcel
import android.os.Parcelable

class Forecast : Parcelable {

    var day: String? = null
    var weatherDescription: String? = null
    var highTemp: Int = 0
    var lowTemp: Int = 0
    var weatherIconUrl: String? = null

    constructor() {}

    constructor(day: String, weatherDescription: String, highTemp: Int, lowTemp: Int, weatherIconUrl: String) {
        this.day = day
        this.weatherDescription = weatherDescription
        this.highTemp = highTemp
        this.lowTemp = lowTemp
        this.weatherIconUrl = weatherIconUrl
    }

    protected constructor(`in`: Parcel) {
        day = `in`.readString()
        weatherDescription = `in`.readString()
        highTemp = `in`.readInt()
        lowTemp = `in`.readInt()
        weatherIconUrl = `in`.readString()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(day)
        parcel.writeString(weatherDescription)
        parcel.writeInt(highTemp)
        parcel.writeInt(lowTemp)
        parcel.writeString(weatherIconUrl)
    }

    companion object {

        @JvmField val CREATOR: Parcelable.Creator<Forecast> = object : Parcelable.Creator<Forecast> {
            override fun createFromParcel(`in`: Parcel): Forecast {
                return Forecast(`in`)
            }

            override fun newArray(size: Int): Array<Forecast ?> {
                return arrayOfNulls(size)
            }
        }
    }
}
