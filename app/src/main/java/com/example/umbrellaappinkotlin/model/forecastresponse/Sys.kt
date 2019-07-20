package com.example.umbrellaappinkotlin.model.forecastresponse

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Sys : Parcelable {

    @SerializedName("pod")
    @Expose
    var pod: String? = null

    protected constructor(`in`: Parcel) {
        this.pod = `in`.readValue(String::class.java.classLoader) as String
    }

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param pod
     */
    constructor(pod: String) : super() {
        this.pod = pod
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(pod)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField val CREATOR: Creator<Sys> = object : Creator<Sys> {


            override fun createFromParcel(`in`: Parcel): Sys {
                return Sys(`in`)
            }

            override fun newArray(size: Int): Array<Sys ?> {
                return arrayOfNulls(size)
            }

        }
    }

}
