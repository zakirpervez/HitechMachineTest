package com.hitech.hitechmachinetest.ui.composable.profile

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.hitech.hitechmachinetest.api.Repository
import com.hitech.hitechmachinetest.api.entities.ApiResult
import com.hitech.hitechmachinetest.api.service.ERROR_UNKNOWN
import com.hitech.hitechmachinetest.mockhelper.MockDataHelper
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ProfileViewModelTest {
    private val repository: Repository = mockk()

    private lateinit var viewModel: ProfileViewModel

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = ProfileViewModel(repository)
    }

    @After
    fun cleanup() {
        Dispatchers.resetMain()
        unmockkAll()
    }

    @Test
    fun `test fetch users success`() = runBlocking {
        coEvery { repository.fetchUsers() } returns ApiResult.Success(MockDataHelper.getUsersMockData())
        viewModel.fetchUsers()
        viewModel.usersLiveData.observeForever {
            assert(it != null)
            assert(it?.users?.size == 2)
        }
    }

    @Test
    fun `test fetch users failure`() = runBlocking {
        coEvery { repository.fetchUsers() } returns ApiResult.Error(ERROR_UNKNOWN)
        viewModel.fetchUsers()
        viewModel.errorLiveData.observeForever {
            assert(it == ERROR_UNKNOWN)
        }
    }

    @Test
    fun testGetRandomUser() {
        val userResponse = MockDataHelper.getUsersMockData()
        val usersList = userResponse.users!!
        val randomUser = viewModel.getRandomUser(usersList)
        assertTrue(usersList.contains(randomUser))
    }
}
