package com.hitech.hitechmachinetest.model

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class User(
    val fullName: String,
    val email: String,
    val password: String,
    val url: String,
    val imageContent: Uri
) : Parcelable
