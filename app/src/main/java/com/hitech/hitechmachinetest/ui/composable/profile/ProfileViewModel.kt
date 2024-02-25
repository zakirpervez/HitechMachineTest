package com.hitech.hitechmachinetest.ui.composable.profile

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hitech.hitechmachinetest.api.Repository
import com.hitech.hitechmachinetest.api.entities.ApiResult
import com.hitech.hitechmachinetest.api.entities.UserResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class ProfileViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    private val usersMutableLiveData = MutableLiveData<List<UserResponse>?>()
    val usersLiveData: LiveData<List<UserResponse>?> = usersMutableLiveData
    private val loaderMutableLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val loaderLiveData: MutableLiveData<Boolean> = loaderMutableLiveData
    private val errorMutableLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> = errorMutableLiveData

    var fullName: MutableLiveData<String> = MutableLiveData("")
    var email: MutableLiveData<String> = MutableLiveData("")
    var password: MutableLiveData<String> = MutableLiveData("")
    var url: MutableLiveData<String> = MutableLiveData("")
    var imageUri: MutableLiveData<Uri> = MutableLiveData(Uri.EMPTY)

    /**
     * Fetch the users from the server.
     * @see [Repository.fetchUsers]
     */
    fun fetchUsers() = viewModelScope.launch(Dispatchers.IO) {
        loaderLiveData.postValue(true)
        val response = async { repository.fetchUsers() }.await()
        when (response) {
            is ApiResult.Success -> {
                response.data?.let {
                    usersMutableLiveData.postValue(it)
                }
                loaderLiveData.postValue(false)
            }

            is ApiResult.Error -> {
                errorMutableLiveData.postValue(response.errorMessage)
                loaderLiveData.postValue(false)
            }
        }
    }

    fun getRandomUser(users: List<UserResponse?>): UserResponse {
        val index = Random.nextInt(users.size)
        return users[index]!!
    }
}
