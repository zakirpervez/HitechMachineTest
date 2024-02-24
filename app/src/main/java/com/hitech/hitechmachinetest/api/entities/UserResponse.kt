package com.hitech.hitechmachinetest.api.entities

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class UserResponse(
    @field:SerializedName("UserResponse") val users: List<UserResponseItem?>? = null
) : Parcelable
