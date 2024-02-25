package com.hitech.hitechmachinetest.api.source

import com.hitech.hitechmachinetest.api.entities.ApiResult
import com.hitech.hitechmachinetest.api.entities.UserResponse
import com.hitech.hitechmachinetest.api.service.ApiService
import com.hitech.hitechmachinetest.mockhelper.MockDataHelper
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.spyk
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Test
import retrofit2.Response

class ApiDataSourceTest {
    private val apiService = mockk<ApiService>()
    private val apiDataSource = spyk(ApiDataSource(apiService))

    @Test
    fun `fetchUsers should return success`() = runBlocking {
        val mockResponse = MockDataHelper.getUsersMockData()
        coEvery { apiService.fetchUsers() } returns Response.success(mockResponse)
        val result = apiDataSource.fetchUsers()
        coVerify { apiService.fetchUsers() }
        assert(result is ApiResult.Success)
        assert((result as ApiResult.Success<List<UserResponse>?>).data?.size == 2)
    }

    @Test
    fun `fetchUsers should return error`() = runBlocking {
        coEvery { apiService.fetchUsers() } returns Response.error(
            404,
            "Not Found".toResponseBody()
        )
        val result = apiDataSource.fetchUsers()
        coVerify { apiService.fetchUsers() }
        assert(result is ApiResult.Error)
        assert((result as ApiResult.Error).errorMessage.contains("404"))
    }
}
