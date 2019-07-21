package com.example.umbrellaappinkotlin.model.forecastresponse

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class City : Parcelable {

    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("coord")
    @Expose
    var coord: Coord? = null
    @SerializedName("country")
    @Expose
    var country: String? = null
    @SerializedName("timezone")
    @Expose
    var timezone: Int? = null

    protected constructor(`in`: Parcel) {
        this.name = `in`.readValue(String::class.java.classLoader) as String
        this.coord = `in`.readValue(Coord::class.java.classLoader) as Coord
        this.country = `in`.readValue(String::class.java.classLoader) as String
        this.timezone = `in`.readValue(Int::class.java.classLoader) as Int
    }

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param coord
     * @param timezone
     * @param name
     * @param country
     */
    constructor(name: String, coord: Coord, country: String, timezone: Int?) : super() {
        this.name = name
        this.coord = coord
        this.country = country
        this.timezone = timezone
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(name)
        dest.writeValue(coord)
        dest.writeValue(country)
        dest.writeValue(timezone)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Creator<City> {
        override fun createFromParcel(parcel: Parcel): City {
            return City(parcel)
        }

        override fun newArray(size: Int): Array<City?> {
            return arrayOfNulls(size)
        }
    }

}
