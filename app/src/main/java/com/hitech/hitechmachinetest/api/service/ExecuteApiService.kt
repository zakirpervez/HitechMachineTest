package com.hitech.hitechmachinetest.api.service

import com.hitech.hitechmachinetest.api.entities.ApiResult
import retrofit2.Response

const val ERROR_RESPONSE_NULL = "Response body is null"
const val ERROR_UNKNOWN = "Something went wrong"

open class ExecuteApiService {
    suspend fun <T> execute(call: suspend () -> Response<T>): ApiResult<T> {
        try {
            val apiResponse = call.invoke()
            return if (apiResponse.isSuccessful) {
                val body = apiResponse.body()
                if (body != null) {
                    ApiResult.Success(body)
                } else {
                    ApiResult.Error("$ERROR_RESPONSE_NULL ${apiResponse.code()}")
                }
            } else {
                val error = apiResponse.message().takeIf { it.isNotEmpty() } ?: ERROR_UNKNOWN
                ApiResult.Error("$error ${apiResponse.code()}")
            }
        } catch (e: Exception) {
            // Handle exceptions, e.g., network issues
            return ApiResult.Error(e.message ?: ERROR_UNKNOWN)
        }
    }
}
