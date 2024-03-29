package com.hitech.hitechmachinetest.model

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * A DTO object used to transfer data between SignUpScreen and ProfileReviewScreen.
 */
@Parcelize
data class User(
    val fullName: String,
    val email: String,
    val password: String,
    val url: String,
    val imageUri: Uri
) : Parcelable
