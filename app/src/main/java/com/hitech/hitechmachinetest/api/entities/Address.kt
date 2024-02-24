package com.hitech.hitechmachinetest.api.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Address(

    @field:SerializedName("zipcode") val zipcode: String? = null,

    @field:SerializedName("geo") val geo: Geo? = null,

    @field:SerializedName("suite") val suite: String? = null,

    @field:SerializedName("city") val city: String? = null,

    @field:SerializedName("street") val street: String? = null
) : Parcelable
