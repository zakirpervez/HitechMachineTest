package com.hitech.hitechmachinetest.ui.composable.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.hitech.hitechmachinetest.R
import com.hitech.hitechmachinetest.ui.composable.common.AppRedButton
import com.hitech.hitechmachinetest.ui.composable.common.DescriptionText
import com.hitech.hitechmachinetest.ui.composable.common.HeaderText
import com.hitech.hitechmachinetest.ui.composable.common.HorizontalSpacer
import com.hitech.hitechmachinetest.ui.composable.common.NormalText
import com.hitech.hitechmachinetest.ui.composable.common.ProgressIndicator

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ProfileReviewScreen(profileViewModel: ProfileViewModel) {
    val usersState = profileViewModel.usersLiveData.observeAsState(null)
    val loadingState = profileViewModel.loaderLiveData.observeAsState(null)
//    val errorState = profileViewModel.errorLiveData.observeAsState(null)

    usersState.value?.apply {
        val user = profileViewModel.getRandomUser(this)
        profileViewModel.fullName.value = user.name!!
        profileViewModel.email.value = user.email!!
        profileViewModel.url.value = user.website!!
    }

    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 16.dp)
                .background(color = Color.White),
            verticalArrangement = Arrangement.Top
        ) {
            HeaderText(
                text = stringResource(
                    id = R.string.hello_user_text,
                    profileViewModel.fullName.value!!
                )
            )
            HorizontalSpacer(height = 4.dp)
            DescriptionText(text = stringResource(id = R.string.portfolio_text))
            HorizontalSpacer(height = 16.dp)
            Box(
                modifier = Modifier
                    .width(160.dp)
                    .height(220.dp)
                    .background(
                        color = Color.LightGray, shape = RoundedCornerShape(16.dp)
                    )
                    .align(alignment = Alignment.CenterHorizontally),
            ) {
                profileViewModel.imageUri.value.let {
                    Image(
                        painter = rememberImagePainter(it),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
            HorizontalSpacer(height = 16.dp)
            NormalText(
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                text = profileViewModel.url.value!!,
                color = Color.Blue
            )
            HorizontalSpacer(height = 16.dp)
            NormalText(
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                text = profileViewModel.fullName.value!!
            )
            HorizontalSpacer(height = 16.dp)
            NormalText(
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                text = profileViewModel.email.value!!
            )
        }
        AppRedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(alignment = Alignment.BottomCenter)
                .height(48.dp),
            buttonText = stringResource(id = R.string.sign_in_text)
        ) {
            profileViewModel.fetchUsers()
        }
    }

    loadingState.value?.apply {
        if (this) {
            ProgressIndicator()
        }
    }

//    errorState.value?.apply {
//        Error(
//            title = stringResource(id = R.string.no_data_found),
//            content = this,
//            modifier = Modifier
//                .fillMaxSize()
//                .background(color = TurmericYellow)
//        )
//    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    val profileViewModel: ProfileViewModel = hiltViewModel()
    ProfileReviewScreen(profileViewModel)
}