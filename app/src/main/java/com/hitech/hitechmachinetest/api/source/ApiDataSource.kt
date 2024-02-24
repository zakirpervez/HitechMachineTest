package com.hitech.hitechmachinetest.api.source

import com.hitech.hitechmachinetest.api.service.ApiService
import com.hitech.hitechmachinetest.api.service.ExecuteApiService
import javax.inject.Inject

class ApiDataSource @Inject constructor(private val apiService: ApiService) : ExecuteApiService() {
    suspend fun fetchUsers() = execute {
        apiService.fetchUsers()
    }
}
