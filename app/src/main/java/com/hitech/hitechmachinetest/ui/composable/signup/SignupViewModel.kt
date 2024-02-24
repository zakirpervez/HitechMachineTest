package com.hitech.hitechmachinetest.ui.composable.signup

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.hitech.hitechmachinetest.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor() : ViewModel() {

    var url: String = ""
    var email: String = ""
    var fullName: String = ""
    var password: String = ""
    var imageUri: Uri = Uri.EMPTY

    fun isValidEmail(): Boolean {
        if (email.isEmpty()) return false
        val emailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()
        return email.matches(emailRegex)
    }

    fun isValidName(): Boolean {
        if (fullName.isEmpty()) return false
        val nameRegex = "^[A-Za-z ]+\$".toRegex()
        return fullName.matches(nameRegex)
    }

    fun isValidPassword(): Boolean {
        if (password.isEmpty()) return false
        val passwordRegex =
            "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d!@#\$%^&*()_+,-./:;<=>?\\\\`{|}~]+\$".toRegex()
        return password.matches(passwordRegex)
    }

    fun isValidUrl(): Boolean {
        if (url.isEmpty()) return false
        val urlRegex = "^(https?|ftp)://[^\\s/\$.?#].\\S*\$".toRegex()
        return url.matches(urlRegex)
    }

    fun isValidImageUri(): Boolean {
        return imageUri.toString().isNotEmpty()
    }

    fun getUser(): User {
        return User(
            fullName = fullName,
            email = email,
            password = password,
            url = url,
            imageContent = imageUri
        )
    }
}