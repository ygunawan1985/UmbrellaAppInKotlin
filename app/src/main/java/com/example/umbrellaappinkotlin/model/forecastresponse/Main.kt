package com.example.umbrellaappinkotlin.model.forecastresponse

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Main : Parcelable {

    @SerializedName("temp")
    @Expose
    var temp: Float? = null
    @SerializedName("temp_min")
    @Expose
    var tempMin: Float? = null
    @SerializedName("temp_max")
    @Expose
    var tempMax: Float? = null
    @SerializedName("pressure")
    @Expose
    var pressure: Float? = null
    @SerializedName("sea_level")
    @Expose
    var seaLevel: Float? = null
    @SerializedName("grnd_level")
    @Expose
    var grndLevel: Float? = null
    @SerializedName("humidity")
    @Expose
    var humidity: Int? = null
    @SerializedName("temp_kf")
    @Expose
    var tempKf: Float? = null

    protected constructor(`in`: Parcel) {
        this.temp = `in`.readValue(Float::class.java.classLoader) as Float
        this.tempMin = `in`.readValue(Float::class.java.classLoader) as Float
        this.tempMax = `in`.readValue(Float::class.java.classLoader) as Float
        this.pressure = `in`.readValue(Float::class.java.classLoader) as Float
        this.seaLevel = `in`.readValue(Float::class.java.classLoader) as Float
        this.grndLevel = `in`.readValue(Float::class.java.classLoader) as Float
        this.humidity = `in`.readValue(Int::class.java.classLoader) as Int
        this.tempKf = `in`.readValue(Float::class.java.classLoader) as Float
    }

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param seaLevel
     * @param humidity
     * @param pressure
     * @param grndLevel
     * @param tempMax
     * @param temp
     * @param tempKf
     * @param tempMin
     */
    constructor(
        temp: Float?,
        tempMin: Float?,
        tempMax: Float?,
        pressure: Float?,
        seaLevel: Float?,
        grndLevel: Float?,
        humidity: Int?,
        tempKf: Float?
    ) : super() {
        this.temp = temp
        this.tempMin = tempMin
        this.tempMax = tempMax
        this.pressure = pressure
        this.seaLevel = seaLevel
        this.grndLevel = grndLevel
        this.humidity = humidity
        this.tempKf = tempKf
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(temp)
        dest.writeValue(tempMin)
        dest.writeValue(tempMax)
        dest.writeValue(pressure)
        dest.writeValue(seaLevel)
        dest.writeValue(grndLevel)
        dest.writeValue(humidity)
        dest.writeValue(tempKf)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Creator<Main> {
        override fun createFromParcel(parcel: Parcel): Main {
            return Main(parcel)
        }

        override fun newArray(size: Int): Array<Main?> {
            return arrayOfNulls(size)
        }
    }

}
