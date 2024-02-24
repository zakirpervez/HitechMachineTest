package com.hitech.hitechmachinetest.api

import com.hitech.hitechmachinetest.api.source.ApiDataSource
import javax.inject.Inject

/**
 * Mediator class to connect the data sources with view-models.
 */
class Repository @Inject constructor(private val apiDataSource: ApiDataSource) {

    /**
     * Fetch the users from the [ApiDataSource].
     * @see [ApiDataSource.fetchUsers]
     * @return ApiResult of UserResponse object.
     */
    suspend fun fetchUsers() = apiDataSource.fetchUsers()
}
