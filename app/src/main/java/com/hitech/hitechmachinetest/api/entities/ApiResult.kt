package com.hitech.hitechmachinetest.api.entities

sealed class ApiResult<out T> {
    /** Return it when api call is successful */
    data class Success<out T>(val data: T) : ApiResult<T>()

    /** Return it when api call failed */
    data class Error(val errorMessage: String) : ApiResult<Nothing>()
}
