package com.hitech.hitechmachinetest.ui.composable.profile

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hitech.hitechmachinetest.api.Repository
import com.hitech.hitechmachinetest.api.entities.ApiResult
import com.hitech.hitechmachinetest.api.entities.UserResponse
import com.hitech.hitechmachinetest.api.entities.UserResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class ProfileViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    private val usersMutableLiveData = MutableLiveData<UserResponse?>()
    val usersLiveData: LiveData<UserResponse?> = usersMutableLiveData
    private val loaderMutableLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val loaderLiveData: MutableLiveData<Boolean> = loaderMutableLiveData
    private val errorMutableLiveData = MutableLiveData<String>()
//    val errorLiveData: LiveData<String> = errorMutableLiveData

    val fullName: MutableLiveData<String> = MutableLiveData()
    val email: MutableLiveData<String> = MutableLiveData()
    val password: MutableLiveData<String> = MutableLiveData()
    val url: MutableLiveData<String> = MutableLiveData()
    val imageUri: MutableLiveData<Uri> = MutableLiveData()


    /**
     * Fetch the users from the server.
     * @see [Repository.fetchUsers]
     */
    fun fetchUsers() = viewModelScope.launch(Dispatchers.IO) {
        loaderLiveData.postValue(true)
        when (val response = async { repository.fetchUsers() }.await()) {
            is ApiResult.Success<UserResponse> -> {
                usersMutableLiveData.postValue(response.data)
                loaderLiveData.postValue(false)
            }

            is ApiResult.Error -> {
                errorMutableLiveData.postValue(response.errorMessage)
                loaderLiveData.postValue(false)
            }
        }
    }

    fun getRandomUser(users: List<UserResponseItem?>): UserResponseItem {
        val index = Random.nextInt(users.size)
        return users[index]!!
    }
}
