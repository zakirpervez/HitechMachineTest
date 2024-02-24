package com.hitech.hitechmachinetest.ui.composable

import com.hitech.hitechmachinetest.model.User
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test

class SharedViewModelTest {
    private lateinit var viewModel: SharedViewModel
    private val mockUser: User = mockk()

    @Before
    fun setUp() {
        viewModel = SharedViewModel()
    }

    @Test
    fun `test user initial value is null`() {
        assertNull(viewModel.user)
    }

    @Test
    fun `test set user`() {
        viewModel.user = mockUser
        assertEquals(mockUser, viewModel.user)
    }
}
