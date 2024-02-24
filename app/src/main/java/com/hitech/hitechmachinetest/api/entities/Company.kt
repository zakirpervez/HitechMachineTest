package com.hitech.hitechmachinetest.api.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Company(

    @field:SerializedName("bs") val bs: String? = null,

    @field:SerializedName("catchPhrase") val catchPhrase: String? = null,

    @field:SerializedName("name") val name: String? = null
) : Parcelable
