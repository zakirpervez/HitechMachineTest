package com.hitech.hitechmachinetest.api.service

import com.hitech.hitechmachinetest.api.entities.UserResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * Retrofit API service.
 */
interface ApiService {
    /** Fetch the popular movies from the API. */
    @GET("users")
    suspend fun fetchUsers(): Response<UserResponse>
}
