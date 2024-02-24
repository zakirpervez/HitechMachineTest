package com.hitech.hitechmachinetest.api.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Geo(

    @field:SerializedName("lng") val lng: String? = null,

    @field:SerializedName("lat") val lat: String? = null
) : Parcelable
