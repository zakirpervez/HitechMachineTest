package com.hitech.hitechmachinetest.ui.composable.signup

import android.Manifest
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.FileProvider
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.hitech.hitechmachinetest.BuildConfig
import com.hitech.hitechmachinetest.R
import com.hitech.hitechmachinetest.model.User
import com.hitech.hitechmachinetest.ui.composable.common.AppRedButton
import com.hitech.hitechmachinetest.ui.composable.common.DescriptionText
import com.hitech.hitechmachinetest.ui.composable.common.HeaderText
import com.hitech.hitechmachinetest.ui.composable.common.HorizontalSpacer
import com.hitech.hitechmachinetest.ui.composable.common.RoundedTextField
import com.hitech.hitechmachinetest.ui.utils.createImageFile
import com.hitech.hitechmachinetest.ui.utils.showToast

@OptIn(ExperimentalCoilApi::class)
@Composable
fun SignUpScreen(
    viewModel: SignupViewModel,
    onNavigate: (User) -> Unit
) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    val file = context.createImageFile()
    val uri = FileProvider.getUriForFile(
        context,
        BuildConfig.APPLICATION_ID + ".provider",
        file
    )

    var capturedImageUri by remember {
        mutableStateOf<Uri>(Uri.EMPTY)
    }

    val cameraLauncher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) {
        capturedImageUri = uri
        viewModel.imageUri = uri
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {
        if (it) {
            cameraLauncher.launch(uri)
        } else {
            Toast.makeText(context, "Camera Permission Denied", Toast.LENGTH_SHORT).show()
        }
    }
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 16.dp)
                .background(color = Color.White)
                .verticalScroll(scrollState),

            verticalArrangement = Arrangement.Top
        ) {
            HeaderText(text = stringResource(id = R.string.profile_creation_text))
            HorizontalSpacer(height = 4.dp)
            DescriptionText(text = stringResource(id = R.string.profile_creation_description_text))
            HorizontalSpacer(height = 16.dp)
            Box(
                modifier = Modifier
                    .width(160.dp)
                    .height(220.dp)
                    .background(
                        color = Color.LightGray,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .align(alignment = Alignment.CenterHorizontally)
                    .clickable(enabled = true) {
                        permissionLauncher.launch(Manifest.permission.CAMERA)
                    }
            ) {
                if (capturedImageUri.path.isNullOrEmpty()) {
                    Text(
                        modifier = Modifier.align(
                            alignment = Alignment.Center
                        ),
                        text = stringResource(id = R.string.add_avtar_label),
                        fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Center,
                        color = Color.DarkGray,
                        fontSize = 18.sp
                    )
                } else {
                    Image(
                        painter = rememberImagePainter(capturedImageUri),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
            HorizontalSpacer(height = 16.dp)
            RoundedTextField(
                hint = stringResource(id = R.string.full_name_label),
                drawableEnd = Icons.Filled.Person,
                onValueChange = { input ->
                    viewModel.fullName = input
                },
                isError = viewModel.isValidName(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            HorizontalSpacer(height = 16.dp)
            RoundedTextField(
                hint = stringResource(id = R.string.email_label),
                drawableEnd = Icons.Filled.Email,
                onValueChange = { input ->
                    viewModel.email = input
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                isError = viewModel.isValidEmail()
            )
            HorizontalSpacer(height = 16.dp)
            RoundedTextField(
                hint = stringResource(id = R.string.password_label),
                drawableEnd = Icons.Filled.Lock,
                onValueChange = { input ->
                    viewModel.password = input
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                isError = viewModel.isValidPassword()
            )
            HorizontalSpacer(height = 16.dp)
            RoundedTextField(
                hint = stringResource(id = R.string.website_label),
                drawableEnd = Icons.Filled.Menu,
                onValueChange = { input ->
                    viewModel.url = input
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Uri),
                isError = viewModel.isValidUrl()
            )
        }
        AppRedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.BottomCenter)
                .height(48.dp),

            buttonText = stringResource(id = R.string.submit_text)
        ) {
            viewModel.imageUri = capturedImageUri
            val isValid =
                viewModel.isValidName() && viewModel.isValidEmail() && viewModel.isValidPassword() && viewModel.isValidUrl() && viewModel.isValidImageUri()

            if (isValid) {
                onNavigate(viewModel.getUser())
            } else {
                context.showToast("Please enter valid data")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    val viewModel = hiltViewModel<SignupViewModel>()
    SignUpScreen(
        onNavigate = {},
        viewModel = viewModel
    )
}
