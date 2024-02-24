package com.hitech.hitechmachinetest.api.source

import com.hitech.hitechmachinetest.api.service.ApiService
import com.hitech.hitechmachinetest.api.service.ExecuteApiService
import javax.inject.Inject

/**
 * Remote/API data source for fetching data from API.
 */
class ApiDataSource @Inject constructor(private val apiService: ApiService) : ExecuteApiService() {

    /**
     * Fetch users from server.
     */
    suspend fun fetchUsers() = execute {
        apiService.fetchUsers()
    }
}
