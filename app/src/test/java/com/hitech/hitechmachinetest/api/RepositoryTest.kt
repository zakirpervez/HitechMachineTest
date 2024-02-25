package com.hitech.hitechmachinetest.api

import com.hitech.hitechmachinetest.api.entities.ApiResult
import com.hitech.hitechmachinetest.api.service.ERROR_UNKNOWN
import com.hitech.hitechmachinetest.api.source.ApiDataSource
import com.hitech.hitechmachinetest.mockhelper.MockDataHelper
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class RepositoryTest {
    private val apiDataSource = mockk<ApiDataSource>()
    private lateinit var repository: Repository

    @Before
    fun setUp() {
        repository = Repository(apiDataSource)
    }

    @Test
    fun `test fetchUsers success`() = runBlocking {
        coEvery { apiDataSource.fetchUsers() } returns ApiResult.Success(MockDataHelper.getUsersMockData())
        val result = repository.fetchUsers()
        assert(result is ApiResult.Success)
    }

    @Test
    fun `test fetchUsers failure`() = runBlocking {
        coEvery { apiDataSource.fetchUsers() } returns ApiResult.Error(ERROR_UNKNOWN)
        val result = repository.fetchUsers()
        assert(result is ApiResult.Error)
    }
}
