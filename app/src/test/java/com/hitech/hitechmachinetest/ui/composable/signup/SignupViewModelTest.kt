package com.hitech.hitechmachinetest.ui.composable.signup

import android.net.Uri
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class SignupViewModelTest {
    private lateinit var viewModel: SignupViewModel
    private val mockUri: Uri = mockk()

    @Before
    fun setup() {
        viewModel = SignupViewModel()
    }

    @Test
    fun `test valid name`() {
        viewModel.fullName = "John Doe"
        assertTrue(viewModel.isValidName())
    }

    @Test
    fun `test invalid name`() {
        viewModel.fullName = "12345" // Numbers are not allowed in the name
        assertFalse(viewModel.isValidName())
    }

    @Test
    fun `test valid email`() {
        viewModel.email = "test@example.com"
        assertTrue(viewModel.isValidEmail())
    }

    @Test
    fun `test invalid email`() {
        viewModel.email = "invalid_email"
        assertFalse(viewModel.isValidEmail())
    }

    @Test
    fun `test valid password`() {
        viewModel.password = "StrongPassword123!"
        assertTrue(viewModel.isValidPassword())
    }

    @Test
    fun `test invalid password`() {
        viewModel.password = "weakpassword" // No special characters
        assertFalse(viewModel.isValidPassword())
    }

    @Test
    fun `test valid url`() {
        viewModel.url = "https://example.com"
        assertTrue(viewModel.isValidUrl())
    }

    @Test
    fun `test invalid url`() {
        viewModel.url = "invalid-url"
        assertFalse(viewModel.isValidUrl())
    }

    @Test
    fun `test valid imageUri`() {
        every { mockUri.toString() } returns "content://media/external/images/media/123"
        viewModel.imageUri = mockUri
        assertTrue(viewModel.isValidImageUri())
    }

    @Test
    fun `test invalid imageUri`() {
        every { mockUri.toString() } returns ""
        viewModel.imageUri = mockUri
        assertFalse(viewModel.isValidImageUri())
    }

    @Test
    fun `test get user`() {
        viewModel.fullName = "John Doe"
        viewModel.email = "test@example.com"
        viewModel.password = "StrongPassword123!"
        viewModel.url = "https://example.com"
        every { mockUri.toString() } returns "content://media/external/images/media/123"
        viewModel.imageUri = mockUri

        val user = viewModel.getUser()

        assertEquals("John Doe", user.fullName)
        assertEquals("test@example.com", user.email)
        assertEquals("StrongPassword123!", user.password)
        assertEquals("https://example.com", user.url)
        assertEquals(mockUri, user.imageUri)
    }
}
