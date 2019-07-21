package com.example.umbrellaappinkotlin.model.forecastresponse

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class List : Parcelable {

    @SerializedName("dt")
    @Expose
    var dt: Int? = null
    @SerializedName("main")
    @Expose
    var main: Main? = null
    @SerializedName("weather")
    @Expose
    var weather: kotlin.collections.List<Weather>? = null
    @SerializedName("clouds")
    @Expose
    var clouds: Clouds? = null
    @SerializedName("wind")
    @Expose
    var wind: Wind? = null
    @SerializedName("sys")
    @Expose
    var sys: Sys? = null
    @SerializedName("dt_txt")
    @Expose
    var dtTxt: String? = null
    @SerializedName("rain")
    @Expose
    var rain: Rain? = null

    protected constructor(`in`: Parcel) {
        this.dt = `in`.readValue(Int::class.java.classLoader) as Int
        this.main = `in`.readValue(Main::class.java.classLoader) as Main
        `in`.readList(
            this.weather!!,
            com.example.umbrellaappinkotlin.model.forecastresponse.Weather::class.java.getClassLoader()
        )
        this.clouds = `in`.readValue(Clouds::class.java.classLoader) as Clouds
        this.wind = `in`.readValue(Wind::class.java.classLoader) as Wind
        this.sys = `in`.readValue(Sys::class.java.classLoader) as Sys
        this.dtTxt = `in`.readValue(String::class.java.classLoader) as String
        this.rain = `in`.readValue(Rain::class.java.classLoader) as Rain
    }

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param clouds
     * @param dt
     * @param wind
     * @param sys
     * @param dtTxt
     * @param weather
     * @param rain
     * @param main
     */
    constructor(
        dt: Int?,
        main: Main,
        weather: kotlin.collections.List<Weather>,
        clouds: Clouds,
        wind: Wind,
        sys: Sys,
        dtTxt: String,
        rain: Rain
    ) : super() {
        this.dt = dt
        this.main = main
        this.weather = weather
        this.clouds = clouds
        this.wind = wind
        this.sys = sys
        this.dtTxt = dtTxt
        this.rain = rain
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(dt)
        dest.writeValue(main)
        dest.writeList(weather)
        dest.writeValue(clouds)
        dest.writeValue(wind)
        dest.writeValue(sys)
        dest.writeValue(dtTxt)
        dest.writeValue(rain)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Creator<List> {
        override fun createFromParcel(parcel: Parcel): List {
            return List(parcel)
        }

        override fun newArray(size: Int): Array<List?> {
            return arrayOfNulls(size)
        }
    }

}
