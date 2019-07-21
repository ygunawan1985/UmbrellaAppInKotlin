package com.example.umbrellaappinkotlin.model.forecastresponse

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Rain : Parcelable {

    @SerializedName("3h")
    @Expose
    var _3h : Float? = null

    protected constructor(`in`: Parcel) {
        this._3h = (`in`.readValue((Float::class.java.getClassLoader())) as Float)
    }

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param _3h
     */
    constructor(_3h: Float?) : super() {
        this._3h = _3h
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(_3h)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Creator<Rain> {
        override fun createFromParcel(parcel: Parcel): Rain {
            return Rain(parcel)
        }

        override fun newArray(size: Int): Array<Rain?> {
            return arrayOfNulls(size)
        }
    }

}
